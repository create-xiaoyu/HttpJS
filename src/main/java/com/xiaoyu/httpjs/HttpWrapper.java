package com.xiaoyu.httpjs;

import dev.latvian.mods.kubejs.script.ScriptType;
import net.neoforged.fml.loading.FMLPaths;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class HttpWrapper {
    private Path validateAndNormalizePath(String Path) {
        Path minecraftDir = FMLPaths.GAMEDIR.get().normalize().toAbsolutePath();
        Path = Path.replace('\\', '/');
        return minecraftDir.resolve(Path).normalize().toAbsolutePath();
    }

    public void Download(String URL, Path savePath, String FileName) {
        Path normalizedPath = validateAndNormalizePath(String.valueOf(savePath));
        if (Objects.equals(FileName, "null")) {
            FileName = URL.substring(URL.lastIndexOf('/') + 1);
            if (FileName.isEmpty()) {
                FileName = "HttpJS_Download_File";
            }
        }
        savePath = normalizedPath.resolve(FileName).normalize().toAbsolutePath();
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URI(URL).toURL().openConnection();
            try (InputStream input = connection.getInputStream()) {
                Files.copy(input, savePath, StandardCopyOption.REPLACE_EXISTING);
            }
            HttpEventJS event = new HttpEventJS(URL, String.valueOf(savePath), "Code: " + connection.getResponseCode());
            HttpJSPlugin.HTTP_DOWNLOAD.post(ScriptType.SERVER, event);
            HttpJS.LOGGER.info("Download Success {} to {}, Code: {}", URL, savePath, connection.getResponseCode());
        } catch (IOException | URISyntaxException e) {
            HttpJS.LOGGER.error("Download Error: {}", savePath, e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
