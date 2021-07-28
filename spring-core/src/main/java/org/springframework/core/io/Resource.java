/*
 * Copyright 2002-2017 the original author or authors.
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

package org.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * 资源的统一抽象，Resource定义了一些通用方法，子类AbstractResource提供统一的默认实现
 * <p>
 * Interface for a resource descriptor that abstracts from the actual
 * type of underlying resource, such as a file or class path resource.
 *
 * <p>An InputStream can be opened for every resource if it exists in
 * physical form, but a URL or File handle can just be returned for
 * certain resources. The actual behavior is implementation-specific.
 *
 * @author Juergen Hoeller
 * @see #getInputStream()
 * @see #getURL()
 * @see #getURI()
 * @see #getFile()
 * @see WritableResource
 * @see ContextResource
 * @see UrlResource
 * @see ClassPathResource
 * @see FileSystemResource
 * @see PathResource
 * @see ByteArrayResource
 * @see InputStreamResource
 * @since 28.12.2003
 */
public interface Resource extends InputStreamSource {

    /**
     * 资源是否存在
     * <p>
     * Determine whether this resource actually exists in physical form.
     * <p>This method performs a definitive existence check, whereas the
     * existence of a {@code Resource} handle only guarantees a valid
     * descriptor handle.
     */
    boolean exists();

    /**
     * 资源是否可读
     * <p>
     * Indicate whether the contents of this resource can be read via
     * {@link #getInputStream()}.
     * <p>Will be {@code true} for typical resource descriptors;
     * note that actual content reading may still fail when attempted.
     * However, a value of {@code false} is a definitive indication
     * that the resource content cannot be read.
     *
     * @see #getInputStream()
     */
    boolean isReadable();

    /**
     * 资源句柄是否被一个steam打开
     * <p>
     * Indicate whether this resource represents a handle with an open stream.
     * If {@code true}, the InputStream cannot be read multiple times,
     * and must be read and closed to avoid resource leaks.
     * <p>Will be {@code false} for typical resource descriptors.
     */
    boolean isOpen();

    /**
     * 返回资源的URL的句柄
     * <p>
     * Return a URL handle for this resource.
     *
     * @throws IOException if the resource cannot be resolved as URL,
     *                     i.e. if the resource is not available as descriptor
     */
    URL getURL() throws IOException;

    /**
     * 返回资源的URI的句柄
     * <p>
     * Return a URI handle for this resource.
     *
     * @throws IOException if the resource cannot be resolved as URI,
     *                     i.e. if the resource is not available as descriptor
     * @since 2.5
     */
    URI getURI() throws IOException;

    /**
     * 返回资源的FILE的句柄
     * <p>
     * Return a File handle for this resource.
     *
     * @throws java.io.FileNotFoundException if the resource cannot be resolved as
     *                                       absolute file path, i.e. if the resource is not available in a file system
     * @throws IOException                   in case of general resolution/reading failures
     * @see #getInputStream()
     */
    File getFile() throws IOException;

    /**
     * 资源内容的长度
     * <p>
     * Determine the content length for this resource.
     *
     * @throws IOException if the resource cannot be resolved
     *                     (in the file system or as some other known physical resource type)
     */
    long contentLength() throws IOException;

    /**
     * 资源的最后修改时间
     * <p>
     * Determine the last-modified timestamp for this resource.
     *
     * @throws IOException if the resource cannot be resolved
     *                     (in the file system or as some other known physical resource type)
     */
    long lastModified() throws IOException;

    /**
     * 根据资源的相对路径创建新资源
     * <p>
     * Create a resource relative to this resource.
     *
     * @param relativePath the relative path (relative to this resource)
     * @return the resource handle for the relative resource
     * @throws IOException if the relative resource cannot be determined
     */
    Resource createRelative(String relativePath) throws IOException;

    /**
     * 资源文件名
     * <p>
     * Determine a filename for this resource, i.e. typically the last
     * part of the path: for example, "myfile.txt".
     * <p>Returns {@code null} if this type of resource does not
     * have a filename.
     */
    String getFilename();

    /**
     * 资源描述
     * <p>
     * Return a description for this resource,
     * to be used for error output when working with the resource.
     * <p>Implementations are also encouraged to return this value
     * from their {@code toString} method.
     *
     * @see Object#toString()
     */
    String getDescription();

}
