/**
 *   Copyright 2009 Jett Marks
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created Oct 17, 2009
 */
package com.jettmarks.clue.server.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Common location for fetching resources given the URL; returns String.
 * 
 * @author jett
 */
public class ResourceManager
{
  /**
   * Logger for this class
  private static final Logger logger = Logger.getLogger(ResourceManager.class);
   */

  public static String getResource(String sUrl)
  {
    URL url;
    BufferedReader in;
    String inputLine;
    StringBuffer buffer = new StringBuffer(32768);
    try
    {
//      logger.info("getResource: "+sUrl);
      url = new URL(sUrl);
      in = new BufferedReader(new InputStreamReader(url.openStream()));
      while ((inputLine = in.readLine()) != null)
      {
        buffer.append(inputLine).append('\n');
      }

      in.close();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      return null;
    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return buffer.toString();
  }
  
  /**
  *
  * @param fileContents
  * @param fullPath
  * @return
  */
 public static int saveContents(String fileContents, String fullPath)
 {
   int result = 0;
   Writer output = null;
//   logger.debug("saveContents(String, String) - fullPath=" + fullPath);

   try
   {
     // FileWriter always assumes default encoding is OK!
     output = new BufferedWriter(new FileWriter(fullPath));
     output.write(fileContents);
   }
   catch (IOException e)
   {
//     logger.error("saveContents(String, String)", e);

     e.printStackTrace();
     result = -1;
   }
   finally
   {
     try
     {
       if (output != null)
       {
	       output.close();
       }
     }
     catch (IOException e)
     {
//       logger.error("saveContents(String, String)", e);

       e.printStackTrace();
     }
   }
   return result;
 }

}
