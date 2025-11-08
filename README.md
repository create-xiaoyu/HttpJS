中文：

这个模组允许你使用Kubejs来从网络上下载文件

使用方式:

```javascript
HttpJS.Download("链接", "保存路径(从.minecraft开始)", "要保存的文件名，如果为null则使用链接中的文件名")

// 示例
HttpJS.Download("https://example.com/example.txt", "config/httpjs", "null")

// 示例
HttpJS.Download("https://example.com/example.txt", "config/httpjs", "helloworld.txt")
```

> **⚠️ 警告**
> 请确保文件路径存在

> **✅ 谢鸣**
> 此模组开发参照了[**FilesJS**](https://github.com/xiaoliziawa/Files-JS)

English:

This mod allows you to use KubeJS to download files from the internet.

Usage:

```javascript
HttpJS.Download("URL", "Save path (starting from .minecraft)", "File name to save as, use null to keep the name from the URL")

// Example
HttpJS.Download("https://example.com/example.txt", "config/httpjs", "null")

// Example
HttpJS.Download("https://example.com/example.txt", "config/httpjs", "helloworld.txt")
```

> **⚠️ Warning**
> Please make sure the file path exists

> **✅ Acknowledgment**  
> This mod was developed with reference to [**FilesJS**](https://github.com/xiaoliziawa/Files-JS).