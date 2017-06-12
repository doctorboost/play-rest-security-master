package controllers;

import io.swagger.annotations.*;
import models.Todo;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import javax.inject.Inject;

import static play.libs.Json.toJson;
import static play.mvc.Results.ok;

@Api(value = "/todos", description = "description.....")
@Security.Authenticated(Secured.class)
public class TodoController extends Controller {

    @Inject FormFactory formFactory;

    @ApiOperation(value = "get All Todos", nickname = "getAllTodos",
            notes = "Returns List of all Todos",
            response = Todo.class,
            httpMethod = "GET",
            responseContainer = "List")
    public Result getAllTodos() {
        return ok(toJson(Todo.findByUser(SecurityController.getUser())));
    }

    public Result createTodo() {
        Form<Todo> form = formFactory.form(Todo.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }
        else {
            Todo todo = form.get();
            todo.user = SecurityController.getUser();
            todo.save();
            return ok(toJson(todo));
        }
    }
    
}
