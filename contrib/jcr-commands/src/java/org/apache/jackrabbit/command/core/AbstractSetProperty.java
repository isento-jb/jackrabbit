/*
 * Copyright 2004-2005 The Apache Software Foundation or its licensors,
 *                     as applicable.
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
package org.apache.jackrabbit.command.core;

import org.apache.commons.chain.Command;

/**
 * SetProperty superclass.
 */
public abstract class AbstractSetProperty implements Command
{
	// ---------------------------- < keys >

	/** destination node path key */
	protected String parentPathKey = "parentPath";

	/** Property name key */
	protected String nameKey = "name";

	/** Propety type key */
	protected String typeKey = "type";

	/** Property value key */
	protected String valueKey = "value";

	/**
	 * @return Returns the valueKey.
	 */
	public String getValueKey()
	{
		return valueKey;
	}

	/**
	 * @param valueKey
	 *            Set the context attribute key for the value attribute.
	 */
	public void setValueKey(String valueKey)
	{
		this.valueKey = valueKey;
	}

	public String getParentPathKey()
	{
		return parentPathKey;
	}

	public void setParentPathKey(String parentPathKey)
	{
		this.parentPathKey = parentPathKey;
	}

	public String getNameKey()
	{
		return nameKey;
	}

	public void setNameKey(String nameKey)
	{
		this.nameKey = nameKey;
	}

	public String getTypeKey()
	{
		return typeKey;
	}

	public void setTypeKey(String typeKey)
	{
		this.typeKey = typeKey;
	}
}
