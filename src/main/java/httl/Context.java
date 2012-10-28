/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package httl;

import java.util.Map;

/**
 * Context. (API, ThreadLocal, ThreadSafe)
 * 
 * @see httl.spi.parsers.template.WriterTemplate#render(Map, java.io.Writer)
 * @see httl.spi.parsers.template.OutputStreamTemplate#render(Map, java.io.OutputStream)
 * 
 * @author Liang Fei (liangfei0201 AT gmail DOT com)
 */
public final class Context {

	// The thread local holder.
    private static ThreadLocal<Context> LOCAL = new ThreadLocal<Context>();

    /**
     * Get current thread local context.
     * 
     * @return current thread local context.
     */
    public static Context getContext() {
    	Context context = LOCAL.get();
    	if (context == null) {
    		context = new Context(null, null, null);
    		LOCAL.set(context);
    	}
    	return context;
    }

    /**
     * Push context in thread local.
     * 
     * @param parent
     * @param template
     * @param parameters
     */
    public static void pushContext(Template template, Map<String, Object> parameters) {
    	LOCAL.set(new Context(LOCAL.get(), template, parameters));
    }

    /**
     * Pop context in thread local.
     */
    public static void popContext() {
    	Context context = LOCAL.get();
    	if (context != null) {
	    	Context parent = context.getParent();
	    	if (parent != null) {
	    		LOCAL.set(parent);
	    	} else {
	    		LOCAL.remove();
	    	}
    	}
    }

    /**
     * Remove current thread local context.
     */
    public static void removeContext() {
        LOCAL.remove();
    }

    private final Context parent;

	private final Template template;

    private final Map<String, Object> parameters;

    private Context(Context parent, Template template, Map<String, Object> parameters) {
    	this.parent = parent;
        this.template = template;
        this.parameters = parameters;
    }

    /**
     * Get parent context.
     * 
     * @return parent context.
     */
    public Context getParent() {
		return parent;
	}

    /**
     * Get current template.
     * 
     * @see #getContext()
     * @return current template.
     */
    public Template getTemplate() {
        return template;
    }
    
    /**
     * Get current parameters.
     * 
     * @see #getContext()
     * @return current parameters.
     */
    public Map<String, Object> getParameters() {
        return parameters;
    }

}
