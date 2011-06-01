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
 * An uninstantiable class offering foreign convenience methods to convert between JSON and XML strings.
 * 
 * @author toddf
 * @since Jun 7, 2010
 */
public final class JSON
{
	// SECTION: CONSTANTS

	private static final String ARRAY_ITEM_ELEMENT_NAME = "item";
	private static final String ARRAY_ELEMENT_NAME = "list";
	private static final String UNNAMED_ROOT_NAME = "root";

	
	// SECTION: CONSTRUCTOR - PRIVATE
	
	private JSON()
	{
		// simply to prevent instantiation.
	}

	
	// SECTION: CONVENIENCE METHODS

	public static JSONElement fromJson(String jsonString)
	throws JSONException
	{
		if (jsonString == null || jsonString.trim().length() == 0)
		{
			return null;
		}

		String json = jsonString.trim();

		if (json.startsWith("["))
		{
			return new JSONObject().put(ARRAY_ITEM_ELEMENT_NAME, new JSONArray(json));
		}

		return new JSONObject(json);
	}
	
	public static String toJson(JSONElement jsonElement)
	throws JSONException
	{
		return null;
	}
	
	public static JSONElement fromXml(String xml)
	throws JSONException
	{
		return null;
	}
	
	public static String toXml(String json)
	throws JSONException
	{
		return toXml(fromJson(json));
	}

	public static String toXml(JSONElement jsonElement)
	throws JSONException
	{
		String wrappingTag = null;

		if (isJsonArray(jsonElement.first()))
		{
			wrappingTag = ARRAY_ELEMENT_NAME;
		}
		else if (jsonElement.length() > 1)
		{
			wrappingTag = UNNAMED_ROOT_NAME;
		}

		return XML.toString(jsonElement, wrappingTag);
	}


	/**
     * @param object
     * @return
     */
    private static boolean isJsonArray(Object object)
    {
    	return (object instanceof JSONArray);
    }
}
