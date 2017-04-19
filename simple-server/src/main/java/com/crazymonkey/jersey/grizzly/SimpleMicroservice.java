package com.crazymonkey.jersey.grizzly;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.http.server.ServerConfiguration;
import org.glassfish.grizzly.nio.transport.TCPNIOTransport;
import org.glassfish.grizzly.http2.Http2AddOn;
import org.glassfish.grizzly.http2.Http2Configuration;
import org.glassfish.grizzly.threadpool.ThreadPoolConfig;
import org.glassfish.grizzly.strategies.*;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpContainer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.ParserProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;


/**
 * Main class.
 *
 */
public class SimpleMicroservice {
 
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMicroservice.class);

	public static final String DEFAULT_HOST = "localhost";
	public static final int DEFAULT_PORT = 8585;

	private HttpServer grizzly;
	/**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
	public SimpleMicroservice(SimpleMicroserviceOptions options) {
		LOGGER.info("Initialising SimpleMicroservice Server");

		// Create a JAX-RS application
		Application application = new ResourceConfig()
		        .register(MyRestEndpoint.class)  
		        .register(JacksonFeature.class);

		HttpHandler handler = ContainerFactory.createContainer(
                GrizzlyHttpContainer.class, application);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
	    URI baseUri = UriBuilder.fromUri("").scheme("http").host(options.host).port(options.port).build();
	    LOGGER.info("Listening on {}", baseUri);
	    grizzly=GrizzlyHttpServerFactory.createHttpServer(baseUri, false);

	    ServerConfiguration config = grizzly.getServerConfiguration();
        config.addHttpHandler(handler, "/");

        TCPNIOTransport trans = grizzly.getListener("grizzly").getTransport();
        NetworkListener listener = grizzly.getListener("grizzly");
        Http2Configuration configuration = Http2Configuration.builder().build();
        if (options.useHttp2) {
                listener.registerAddOn(new Http2AddOn(configuration));
                listener.setSecure(false);
        }
       trans.setKeepAlive(!options.disableKeepAlive);
        switch (options.iOStrategy) {
        case "WorkerThreadIOStrategy":
    	    trans.setIOStrategy(WorkerThreadIOStrategy.getInstance());
    	    break;
        case "SameThreadIOStrategy":
            trans.setIOStrategy(SameThreadIOStrategy.getInstance());
            break;
        case "SimpleDynamicNIOStrategy":
            trans.setIOStrategy(SimpleDynamicNIOStrategy.getInstance());
            break;
        case "LeaderFollowerNIOStrategy":
            trans.setIOStrategy(LeaderFollowerNIOStrategy.getInstance());
            break;
        }
        trans.setSelectorRunnersCount(options.ioWorkerCount);
        ThreadPoolConfig wkTp = trans.getWorkerThreadPoolConfig();
        if (wkTp != null) {
            wkTp.setCorePoolSize(options.executorThreadCount).setMaxPoolSize(options.executorThreadCount);
        }
        LOGGER.info("Grizzly initalised - Host={}, Port={}, KeepAlive={}, IOWorkCount={}, ExecutorThreadCount={}, IOStrategy {}, HTTP/2 {}",
                options.host, options.port, !options.disableKeepAlive, options.ioWorkerCount,
                options.executorThreadCount, options.iOStrategy, options.useHttp2);
	}

    public void init() {
		LOGGER.info("Starting SimpleMicroservice Server");
		try {
			grizzly.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {

		// Parse Command Line options
		SimpleMicroserviceOptions options = new SimpleMicroserviceOptions();
		ParserProperties parserProps = ParserProperties.defaults();
		parserProps.withUsageWidth(120);
		CmdLineParser parser = new CmdLineParser(options, parserProps);
		try {
			parser.parseArgument(args);
		} catch (CmdLineException e) {
			System.err.println(e.getMessage());
			parser.printUsage(System.err);
			System.exit(1);
		}

		SimpleMicroservice simpleMicroservice = new SimpleMicroservice(options);
		simpleMicroservice.init();
        System.out.println("Press enter to exit...");
        try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}    
}

