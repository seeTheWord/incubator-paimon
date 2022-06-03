/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.store.table.source;

import org.apache.flink.core.fs.Path;
import org.apache.flink.table.data.binary.BinaryRowData;
import org.apache.flink.table.store.file.data.DataFileMeta;

import java.util.List;

/** Input splits. Needed by most batch computation engines. */
public class Split {

    private final BinaryRowData partition;
    private final int bucket;
    private final List<DataFileMeta> files;

    private final Path bucketPath;

    public Split(BinaryRowData partition, int bucket, List<DataFileMeta> files, Path bucketPath) {
        this.partition = partition;
        this.bucket = bucket;
        this.files = files;

        this.bucketPath = bucketPath;
    }

    public BinaryRowData partition() {
        return partition;
    }

    public int bucket() {
        return bucket;
    }

    public List<DataFileMeta> files() {
        return files;
    }

    public Path bucketPath() {
        return bucketPath;
    }
}
