/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Utils;

/**
 * A collection of utility methods that support asserting conditions.
 */
public class Assert
{
    public static void areEqual(Object expected, Object actual)
    {
        assert expected != null && expected.equals(actual);
    }

    public static void isTrue(boolean condition, String message)
    {
        assert condition : message;
    }

    public static void isNotNull(Object actual)
    {
        assert actual != null;
    }
}
