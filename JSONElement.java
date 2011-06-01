/*
    Copyright 2010, Strategic Gains, Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package org.json;

/**
 * @author toddf
 * @since Jun 7, 2010
 */
public abstract class JSONElement
{
	public boolean isJsonArray()
	{
		return (this instanceof JSONArray);
	}
	
	public boolean isJsonObject()
	{
		return (this instanceof JSONObject);
	}
	
	public Object first()
	throws JSONException
	{
		if (!isJsonObject())
		{
			throw new JSONException("first() is not supported.");
		}
		
		JSONObject object = (JSONObject) this;
		return object.get((String) object.keys().next());

	}
	
	public abstract int length();
}
