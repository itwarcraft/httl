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
package httl.spi.switchers;

import httl.spi.Filter;
import httl.spi.Switcher;

/**
 * StyleTextFilterSwitcher. (SPI, Singleton, ThreadSafe)
 * 
 * @see httl.spi.parsers.AbstractParser#setTextFilterSwitcher(Switcher)
 * 
 * @author Liang Fei (liangfei0201 AT gmail DOT com)
 */
public class StyleTextFilterSwitcher extends StyleFilterSwitcher {

	/**
	 * httl.properties: style.text.filter=httl.spi.filters.StyleTextFilter
	 */
	public void setStyleTextFilter(Filter filter) {
		setStyleFilter(filter);
	}

}