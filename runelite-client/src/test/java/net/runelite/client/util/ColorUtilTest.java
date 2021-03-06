/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.util;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ColorUtilTest
{
	private static final Map<Color, String> COLOR_HEXSTRING_MAP = new HashMap<Color, String>()
	{{
		put(Color.BLACK, "000000");
		put(new Color(0x1), "000001");
		put(new Color(0x100000), "100000");
		put(Color.RED, "ff0000");
		put(Color.GREEN, "00ff00");
		put(Color.BLUE, "0000ff");
		put(new Color(0xA1B2C3), "a1b2c3");
		put(Color.WHITE, "ffffff");
	}};

	@Test
	public void colorTag()
	{
		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals("<col=" + hex + ">", ColorUtil.colorTag(color));
		});
	}

	@Test
	public void prependColorTag()
	{
		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals("<col=" + hex + ">SuwOverlay", ColorUtil.prependColorTag("SuwOverlay", color));
			assertEquals("<col=" + hex + ">", ColorUtil.prependColorTag("", color));
		});

		assertEquals("<col=ff0000>94<col=ffffff>/99", ColorUtil.prependColorTag("94" + ColorUtil.prependColorTag("/99", Color.WHITE), Color.RED));
	}

	@Test
	public void wrapWithColorTag()
	{
		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals("<col=" + hex + ">SuwOverlay</col>", ColorUtil.wrapWithColorTag("SuwOverlay", color));
			assertEquals("<col=" + hex + "></col>", ColorUtil.wrapWithColorTag("", color));
		});
	}

	@Test
	public void toHexColor()
	{
		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals("#" + hex, ColorUtil.toHexColor(color));
		});
	}

	@Test
	public void colorLerp()
	{
		assertEquals(Color.WHITE, ColorUtil.colorLerp(Color.WHITE, Color.WHITE, 0.9));
		assertEquals(new Color(128, 128, 128), ColorUtil.colorLerp(Color.BLACK, Color.WHITE, 0.5));
		assertEquals(Color.BLACK, ColorUtil.colorLerp(Color.BLACK, Color.CYAN, 0));
		assertEquals(Color.CYAN, ColorUtil.colorLerp(Color.BLACK, Color.CYAN, 1));
	}

	@Test
	public void colorToHexCode()
	{
		COLOR_HEXSTRING_MAP.forEach((color, hex) ->
		{
			assertEquals(hex, ColorUtil.colorToHexCode(color));
		});
	}

	@Test
	public void isFullyTransparent()
	{
		for (Color color : COLOR_HEXSTRING_MAP.keySet())
		{
			assertFalse(ColorUtil.isFullyTransparent(color));
		}
		assertTrue(ColorUtil.isFullyTransparent(new Color(0, 0, 0, 0)));
		assertFalse(ColorUtil.isFullyTransparent(new Color(0, 0, 0, 1)));
	}

	@Test
	public void isNotFullyTransparent()
	{
		for (Color color : COLOR_HEXSTRING_MAP.keySet())
		{
			assertTrue(ColorUtil.isNotFullyTransparent(color));
		}
		assertFalse(ColorUtil.isNotFullyTransparent(new Color(0, 0, 0, 0)));
		assertTrue(ColorUtil.isNotFullyTransparent(new Color(0, 0, 0, 1)));
	}
}
