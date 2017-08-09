package org.superbiz.moviefun;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by pivotal on 8/9/17.
 */
public interface BlobStore {

    void put(Blob blob) throws IOException;

    Optional<Blob> get(String name) throws IOException;
}
