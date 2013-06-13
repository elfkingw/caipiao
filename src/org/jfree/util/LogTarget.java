﻿/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
 * 
 * Project Info:  http://www.jfree.org/jcommon/index.html
 *
 * This library is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation; either version 2.1 of the License, or 
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, 
 * USA.  
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 * 
 * --------------
 * LogTarget.java
 * --------------
 * (C)opyright 2002-2004, by Object Refinery Limited.
 *
 * $Id: LogTarget.java,v 1.3 2005/11/14 10:55:59 mungady Exp $
 *
 * Changes
 * -------
 * 11-May-2002 : Initial version
 * 06-Dec-2002 : LogTargets now use Object-Parameters instead of Strings.
 * 05-Feb-2003 : Removed unnecessary methods.
 * 29-Apr-2003 : Distilled from the JFreeReport project and moved into JCommon
 * 
 */

package org.jfree.util;

/**
 * An interface that defines a log target (a consumer of log messages).  Classes which
 * implement this interface can be registered with the {@link org.jfree.util.Log} class
 * and will then receive logging messages generated by the code.
 *
 * @author Thomas Morgner
 */
public interface LogTarget {

    /**
     * Loglevel ERROR.
     */
    public static final int ERROR = 0;

    /**
     * Loglevel WARN.
     */
    public static final int WARN = 1;

    /**
     * Loglevel INFO.
     */
    public static final int INFO = 2;

    /**
     * Loglevel DEBUG.
     */
    public static final int DEBUG = 3;

    /** Strings for the log levels. */
    public static final String[] LEVELS =
        {
            "ERROR: ",
            "WARN:  ",
            "INFO:  ",
            "DEBUG: "
        };

    /**
     * Logs a message at a specified log level.
     *
     * @param level  the log level.
     * @param message  the log message.
     */
    public void log(int level, Object message);

    /**
     * Logs a message at a specified log level.
     *
     * @param level  the log level.
     * @param message  the log message.
     * @param e  the exception
     */
    public void log(int level, Object message, Exception e);
}
