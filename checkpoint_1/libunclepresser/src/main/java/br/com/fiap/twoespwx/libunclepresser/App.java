/* 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Grupo: Elite Jobs
 * Autores: 
 *      - Anna Yagyu     -   rm550360
 *      - Breno Silva     -   rm99275
 *      - Danilo Urze    -   rm99465
 *      - Pedro Henrique  -   rm550689
 */

package br.com.fiap.twoespwx.libunclepresser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.util.*;

public class App
{
    public static void main( String[] args ) {

    }
    private static String readInputFile(String inputPath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(inputPath));
        return new String(bytes, StandardCharsets.UTF_8).replaceAll("\\s+", "").toUpperCase();
    }


}
