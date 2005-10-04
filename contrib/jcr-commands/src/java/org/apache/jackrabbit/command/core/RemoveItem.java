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

import javax.jcr.Item;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.jackrabbit.command.CommandHelper;

/**
 * Removes the item at the given path.
 */
public class RemoveItem implements Command
{
	/** logger */
	private static Log log = LogFactory.getLog(RemoveItem.class);

	// ---------------------------- < keys >

	/** context attribute key for the path attribute */
	private String pathKey = "path";

	/**
	 * @inheritDoc
	 */
	public boolean execute(Context ctx) throws Exception
	{
		String path = (String) ctx.get(this.pathKey);
		if (log.isDebugEnabled())
		{
			log.debug("removing item from " + path);
		}
		Item item = CommandHelper.getItem(ctx, path);
		if (item.isSame(CommandHelper.getCurrentNode(ctx))
				&& item.getDepth() > 0)
		{
			CommandHelper.setCurrentNode(ctx, item.getParent());
		}
		item.remove();
		return false;
	}

	/**
	 * @return Returns the pathKey.
	 */
	public String getPathKey()
	{
		return pathKey;
	}

	/**
	 * @param pathKey
	 *            The pathKey to set.
	 */
	public void setPathKey(String pathKey)
	{
		this.pathKey = pathKey;
	}
}
