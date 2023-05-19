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

package io.github.secretx33.resourceresolver;

import java.io.IOException;

/**
 * Strategy interface for resolving a location pattern (for example,
 * an Ant-style path pattern) into {@link Resource} objects.
 *
 * <p>This is an extension to the {@link ResourceLoader} interface.
 * A passed-in {@code ResourceLoader} can be checked whether it implements
 * this extended interface too.
 *
 * <p>Can be used with any sort of location pattern &mdash; for example,
 * {@code "/WEB-INF/*-context.xml"}. However, input patterns have to match the
 * strategy implementation. This interface just specifies the conversion method
 * rather than a specific pattern format.
 *
 * <p>This interface also defines a {@value #CLASSPATH_ALL_URL_PREFIX} resource
 * prefix for all matching resources from the module path and the class path. Note
 * that the resource location may also contain placeholders &mdash; for example
 * {@code "/beans-*.xml"}. JAR files or different directories in the module path
 * or class path can contain multiple files of the same name.
 *
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @since 1.0.2
 * @see Resource
 * @see ResourceLoader
 */
public interface ResourcePatternResolver extends ResourceLoader {

    /**
     * Pseudo URL prefix for all matching resources from the class path: {@code "classpath*:"}.
     * <p>This differs from ResourceLoader's {@code "classpath:"} URL prefix in
     * that it retrieves all matching resources for a given path &mdash; for
     * example, to locate all "beans.xml" files in the root of all deployed JAR
     * files you can use the location pattern {@code "classpath*:/beans.xml"}.
     * <p>The semantics for the {@code "classpath*:"}
     * prefix have been expanded to include the module path as well as the class path.
     * @see ResourceLoader#CLASSPATH_URL_PREFIX
     */
    String CLASSPATH_ALL_URL_PREFIX = "classpath*:";

    /**
     * Resolve the given location pattern into {@code Resource} objects.
     * <p>Overlapping resource entries that point to the same physical
     * resource should be avoided, as far as possible. The result should
     * have set semantics.
     * @param locationPattern the location pattern to resolve
     * @return the corresponding {@code Resource} objects
     * @throws IOException in case of I/O errors
     */
    Resource[] getResources(String locationPattern) throws IOException;

}
