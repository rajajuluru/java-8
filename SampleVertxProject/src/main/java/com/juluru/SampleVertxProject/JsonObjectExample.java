package com.juluru.SampleVertxProject;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class JsonObjectExample extends AbstractVerticle {
	public static	Vertx mainvertex = Vertx.vertx();
	
public static void main(String[] args) {

	mainvertex.deployVerticle(new JsonObjectExample());

	
	Router route=Router.router(mainvertex);
	route.get().produces("")
	.handler(context->{
		
	});
	
	Promise<Object> promise = Promise.promise();
	//CompletableFuture<Object> future = promise.future();
	JsonObject json=new JsonObject();
	json.put("name", "raja");
	json.put("age", 24);
	System.out.println(json);
	String encode = json.encode();
System.out.println("encoded json"+encode);

json.forEach(s->{
	System.out.println(s.getKey()+"                    "+s.getValue());
});
}
@Override
public void start(Promise<Void> startPromise) throws Exception {
	
	//Vertx mainvertex = Vertx.vertx();
	Router router=Router.router(mainvertex);
	
	//router.get().handler(arg0);
	router.get("/hello").handler(contexthandle->{
		contexthandle.end("hello vertex");
		contexthandle.fileUploads();
	});
  vertx.createHttpServer().requestHandler(router).listen(9999, http -> {
    if (http.succeeded()) {
      startPromise.complete();
      System.out.println("HTTP server started on port 9999");
    } else {
      startPromise.fail(http.cause());
    }
  });
}
}
