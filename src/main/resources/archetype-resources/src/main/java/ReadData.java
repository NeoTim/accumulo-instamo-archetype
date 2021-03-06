/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${package};

import org.apache.accumulo.core.client.Accumulo;
import org.apache.accumulo.core.client.AccumuloClient;
import org.apache.accumulo.core.client.Scanner;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.security.Authorizations;

/**
 * Reads all data between two rows
 */
public class ReadData {
  // usage: java instamo.ReadData /path/to/client.properties
  public static void main(String[] args) throws Exception {
    try (AccumuloClient client = Accumulo.newClient().from(args[0]).build();
        Scanner scan = client.createScanner("hellotable", Authorizations.EMPTY)) {
      scan.setRange(new Range(new Key("row_0"), new Key("row_1002")));
      scan.forEach(System.out::println);
    }
  }
}
