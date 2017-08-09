package org.superbiz.moviefun;

import org.apache.tika.Tika;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

import static java.lang.String.format;

/**
 * Created by pivotal on 8/9/17.
 */
public class FileStore implements BlobStore {

    private final Tika tika = new Tika();

    @Override
    public void put(Blob blob) throws IOException {

    }

    @Override
    public Optional<Blob> get(String name) throws IOException {
        File file = new File(name);

        if (!file.exists()) {
            return Optional.empty();
        }

        return Optional.of(new Blob(
                name,
                new FileInputStream(file),
                tika.detect(file)
        ));
    }
}
