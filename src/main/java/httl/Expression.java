/*
 * Copyright 2011-2013 HTTL Team.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package httl;

import java.text.ParseException;
import java.util.Map;

/**
 * Expression. (API, Prototype, Immutable, ThreadSafe)
 * 
 * <pre>
 * Engine engine = Engine.getEngine();
 * Expression expression = engine.getExpression("1 + 2");
 * </pre>
 * 
 * @see httl.Engine#getExpression(String)
 * @see httl.Engine#getExpression(String, Map)
 * @see httl.spi.Translator#translate(String, java.util.Map, int)
 * 
 * @author Liang Fei (liangfei0201 AT gmail DOT com)
 */
public interface Expression {

	/**
	 * Evaluate the expression.
	 * 
	 * <pre>
	 * Context context = Context.getContext();
	 * context.put("foo", foo);
	 * Object result = expression.evaluate();
	 * </pre>
	 * 
	 * @return evaluate result
	 * @throws ParseException - If the expression cannot be parsed on runtime
	 */
	Object evaluate() throws ParseException;

	/**
	 * Evaluate the expression.
	 * 
	 * <pre>
	 * Map&lt;String, Object&gt; context = new HashMap&lt;String, Object&gt;();
	 * context.put("foo", foo);
	 * Object result = expression.evaluate(context);
	 * </pre>
	 * 
	 * @param context - evaluate context
	 * @return evaluate result
	 * @throws ParseException - If the expression cannot be parsed on runtime
	 */
	Object evaluate(Object context) throws ParseException;

	/**
	 * Get the expression parameter type.
	 * 
	 * @return parameter type
	 */
	Class<?> getParameterType();

	/**
	 * Get the expression parameter types. (Ordered)
	 * 
	 * @return parameter types
	 */
	Map<String, Class<?>> getParameterTypes();

	/**
	 * Get the expression return type.
	 * 
	 * @return return type
	 */
	Class<?> getReturnType();

	/**
	 * Get the expression code.
	 * 
	 * @return code
	 */
	String getCode();

	/**
	 * Get the expression source.
	 * 
	 * @return source
	 */
	String getSource();

	/**
	 * Get the expression offset.
	 * 
	 * @return offset
	 */
	int getOffset();

	/**
	 * Get the expression engine.
	 * 
	 * @return engine
	 */
	Engine getEngine();

}