package com.crazymonkey.jersey.grizzly;

import org.kohsuke.args4j.Option;

/**
 * Options based on args4j framework for the RestServer
 * 
 */
public class SimpleMicroserviceOptions {
	
	@Option(name = "-h", aliases = "-host", metaVar = "<host>", usage = "Binding Host")
	String host = SimpleMicroservice.DEFAULT_HOST;

	@Option(name = "-p", aliases = "-port", metaVar = "<port>", usage = "Listening Port")
	int port = SimpleMicroservice.DEFAULT_PORT;

	@Option(name = "-w", aliases = "-ioWorkerCount", metaVar = "<count>", usage = "IO Worker Count")
	int ioWorkerCount = 16;

	@Option(name = "-t", aliases = "-executorThreadCount", metaVar = "<count>", usage = "Executor Thread Count")
	int executorThreadCount = 16;

	@Option(name = "-k", aliases = "-noKeepAlive", usage = "Disable HTTP KeepAlive")
	boolean disableKeepAlive = false;

	@Option(name = "-s", aliases = "-IOStrategy", usage = "Set specific IOStrategy")
	String iOStrategy = "SameThreadIOStrategy";

    @Option(name = "-2", aliases = "-http2", usage = "Start as HTTP/2 server")
    boolean useHttp2 = false;

    @Option(name = "-?", aliases = "-help", usage = "Print help")
	boolean help = false;
}
