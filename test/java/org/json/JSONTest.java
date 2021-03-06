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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author toddf
 * @since Jun 7, 2010
 */
public class JSONTest
{

	@Test
	public void shouldConvertJsonNamedListToXmlElements()
	throws JSONException
	{
		String json = "{\"stuff\":[{\"id\":1005,\"subject\":\"foo\"},{\"id\":1006,\"subject\":\"bar\"}]}";
		String xml = JSON.toXml(json);
		assertEquals(
		    "<list><stuff><id>1005</id><subject>foo</subject></stuff><stuff><id>1006</id><subject>bar</subject></stuff></list>",
		    xml);
	}

	@Test
	public void shouldConvertJsonNamedRootToXmlElements() throws JSONException
	{
		String json = "{ \"resource\" : { \"name\" : \"test post\", \"data\" : \"some data\" } }";
		String xml = JSON.toXml(json);
		assertEquals("<resource><name>test post</name><data>some data</data></resource>", xml);
	}

	@Test
	public void shouldConvertJsonUnnamedArrayToXmlElements()
	throws JSONException
	{
		String json = "[{\"id\":1005,\"subject\":\"foo\"},{\"id\":1006,\"subject\":\"bar\"}]";
		String xml = JSON.toXml(json);
		assertEquals("<list><item><id>1005</id><subject>foo</subject></item><item><id>1006</id><subject>bar</subject></item></list>", xml);
	}

	@Test
	public void shouldConvertJsonUnnamedRootToXmlElements()
	throws JSONException
	{
		String json = "{\"access_token\":\"mauth|79889m9rwet|2114798|2010-06-07T09%3a51%3a03|66cb32d9e0cf9ea2dad1f999946af951\",\"expires\":3600}";
		String xml = JSON.toXml(json);
		assertEquals("<root><expires>3600</expires><access_token>mauth|79889m9rwet|2114798|2010-06-07T09%3a51%3a03|66cb32d9e0cf9ea2dad1f999946af951</access_token></root>", xml);
	}

	@Test
	public void shouldConvertJsonNamedValueToXmlElements() throws JSONException
	{
		String json = "{\"access_token\":{\"name\":\"value\"}}";
		String xml = JSON.toXml(json);
		assertEquals("<access_token><name>value</name></access_token>", xml);
	}

	@Test
	public void shouldConvertJsonValueToXmlElements() throws JSONException
	{
		String json = "{\"access_token\":\"value\"}";
		String xml = JSON.toXml(json);
		assertEquals("<access_token>value</access_token>", xml);
	}

	@Test
	public void shouldConvertHeinousJsonUnnamedListToXmlElements()
	throws JSONException
	{
		String json = "[{\"named_list\":[{\"a\":\"a_value\"}, {\"b\":\"b_value\"}, {\"c\":\"c_value\"}]},{\"named_root\":{\"foo\":\"bar\"}},{\"a\":\"b\",\"c\":\"d\"},[{\"humpty\":1}, {\"dumpty\":2}]]";
		String xml = JSON.toXml(json);
		assertEquals("<list><item><named_list><a>a_value</a></named_list><named_list><b>b_value</b></named_list><named_list><c>c_value</c></named_list></item><item><named_root><foo>bar</foo></named_root></item><item><c>d</c><a>b</a></item><item><array><humpty>1</humpty></array><array><dumpty>2</dumpty></array></item></list>", xml);
	}

}
