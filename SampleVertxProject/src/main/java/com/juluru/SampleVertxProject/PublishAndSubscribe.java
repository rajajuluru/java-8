package com.juluru.SampleVertxProject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class PublishAndSubscribe {
	
	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new publishClass());
		
		vertx.deployVerticle(new SubscribeClass());
		
		
		Router router = Router.router(vertx);
		router.get().handler(requestHandler->{
			requestHandler.request().getParam("");
			requestHandler.response().end();
		});
		
	
		
	}
	
	
	
	static class publishClass extends AbstractVerticle{
		
		
		  @Override
		  public void start(Promise<Void> startPromise) throws Exception {
		    startPromise.complete();
		    vertx.setPeriodic(Duration.ofSeconds(10).toMillis(),id->{
		    vertx.eventBus().publish(publishClass.class.getSimpleName(),"hi this is publishers msg");
		    }
		  );
		    }
}

	static class SubscribeClass extends AbstractVerticle{
		@Override
		  public void start(Promise<Void> startPromise) throws Exception {
		    startPromise.complete();
		    vertx.eventBus().consumer(publishClass.class.getSimpleName(),msg->{
		    	System.out.println("received msg is" + msg.body());
		    });
		      }

}
	
	
	
}
