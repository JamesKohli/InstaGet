package com.jameskohli;

import com.jameskohli.core.ShareUrlParser;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Test regex of instagram urls
     */
    public void testShareUrlParserTrue()
    {
        ShareUrlParser sup = new ShareUrlParser("https://instagram.com/p/sykBgGSGAF/");
        ShareUrlParser sup2 = new ShareUrlParser("http://instagram.com/p/sykBgGSGAF");
        assertTrue(sup.getIsValidUrl());
        assertTrue(sup2.getIsValidUrl());

    }

    public void testShareUrlParserFalse()
    {
        ShareUrlParser sup = new ShareUrlParser("https://facebook.com/p/sykBgGSGAF/");
        ShareUrlParser sup2 = new ShareUrlParser("htps://instagram.com/p/sykBgGSGAF/");
        ShareUrlParser sup3 = new ShareUrlParser("instagram.com/p/sykBgGSGAF/");
        ShareUrlParser sup4 = new ShareUrlParser("https://instagram.com/p/asefasgea");
        assertFalse(sup.getIsValidUrl());
        assertFalse(sup2.getIsValidUrl());
        assertFalse(sup3.getIsValidUrl());
        assertFalse(sup4.getIsValidUrl());
    }

    public void testExtractImage() {
        ShareUrlParser sup = new ShareUrlParser("https://instagram.com/p/sykBgGSGAF/");
        assertEquals("https://scontent-atl.cdninstagram.com/hphotos-xaf1/t51.2885-15/10665544_334845526689377_1839313114_n.jpg", sup.getImageUrl());
    }
}
