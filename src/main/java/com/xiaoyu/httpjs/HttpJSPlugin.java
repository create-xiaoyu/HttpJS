package com.xiaoyu.httpjs;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingRegistry;

public class HttpJSPlugin implements KubeJSPlugin {
    public static final EventGroup GROUP = EventGroup.of("HttpJS");
    public static final EventHandler HTTP_DOWNLOAD = GROUP.server("HttpDownload", () -> HttpEventJS.class);

    @Override
    public void registerBindings(BindingRegistry bindings) {
        if (bindings.type().isServer()) {
            bindings.add("HttpJS", new HttpWrapper());
        }
    }

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        registry.register(GROUP);
    }
}
