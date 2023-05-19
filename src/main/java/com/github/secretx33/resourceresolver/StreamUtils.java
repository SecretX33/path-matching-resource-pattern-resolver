/*
 * Copyright 2002-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.secretx33.resourceresolver;

import java.io.InputStream;

/**
 * Simple utility methods for dealing with streams. The copy methods of this class are
 * similar to those defined in {@link com.github.secretx33.resourceresolver.FileCopyUtils} except that all affected streams are
 * left open when done. All copy methods use a block size of 8192 bytes.
 *
 * <p>Mainly for use within the framework, but also useful for application code.
 *
 * @author Juergen Hoeller
 * @author Phillip Webb
 * @author Brian Clozel
 * @since 3.2.2
 * @see com.github.secretx33.resourceresolver.FileCopyUtils
 */
abstract class StreamUtils {

    /**
     * The default buffer size used when copying bytes.
     */
    public static final int BUFFER_SIZE = 8192;

    /**
     * Return an efficient empty {@link InputStream}.
     * @return an InputStream which contains no bytes
     * @since 4.2.2
     * @deprecated as of 6.0 in favor of {@link InputStream#nullInputStream()}
     */
    @Deprecated(since = "6.0")
    public static InputStream emptyInput() {
        return InputStream.nullInputStream();
    }

}
