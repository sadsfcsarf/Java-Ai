# Java-Ai
这个项目是一个基于 Spring Boot 框架开发的 AI 聊天助手应用，主要功能是提供用户与 AI 模型的对话交互，并包含用户认证、聊天记录管理等功能。以下是项目的关键信息整理：
1. 技术栈
后端：Spring Boot、Spring AI（集成 Ollama AI 模型）、MyBatis（数据访问）、MySQL（数据库）。
前端：Vue.js、Element UI（UI 组件库）、Marked.js（Markdown 渲染）、Day.js（时间处理）。
AI 交互：通过 Ollama 调用本地部署的deepseek-r1:1.5b模型（配置在application.properties中）。
2. 核心功能
用户认证：支持用户登录、注册，通过AuthInterceptor拦截器实现接口权限控制（拦截/api/**路径，排除登录 / 注册接口），登录状态通过 Session 管理。
AI 对话：提供两种交互方式：
同步调用：通过/api/chat/call接口直接返回 AI 回答。
流式返回：通过/api/chat/stream接口以流的形式实时返回 AI 回答片段（适合长文本生成）。
聊天记录管理：保存用户与 AI 的对话记录到数据库，可通过/api/chat/list接口查询历史记录。
前端界面：提供聊天交互界面（chat.html），包含消息展示区、输入框、侧边栏（对话管理、设置等），支持 Markdown 格式渲染和消息时间显示。
3. 项目结构
后端核心目录：
com.example.controller：控制器（UserController处理用户相关，ChatController处理 AI 对话）。
com.example.service：业务逻辑（UserService用户服务、MessageService聊天记录服务）。
com.example.dto：数据传输对象（UserDto用户信息、MessageDto消息记录）。
com.example.config：配置类（WebMvcConfig注册拦截器）。
com.example.interceptor：拦截器（AuthInterceptor登录验证）。
前端资源：
静态页面（index.html主页面、chat.html聊天界面）。
CSS 样式（Element UI 相关样式文件）。
JS 脚本（Vue 实例、AI 对话逻辑、Markdown 渲染等）。
配置文件：application.properties配置数据库连接、Ollama 地址、MyBatis 映射等。
4. 数据存储
使用 MySQL 数据库（库名javaai），存储用户信息和聊天记录。
通过 MyBatis 的mapper接口（如UserMapper、消息相关 Mapper）操作数据库，支持下划线与驼峰命名转换。
5. 关键流程
用户登录 / 注册：通过/api/user/login或/api/user/register接口，验证成功后将用户信息存入 Session。
AI 对话：用户输入问题后，前端调用/api/chat/stream接口，后端通过 Ollama 模型生成回答，实时返回并保存对话记录。
权限控制：未登录用户无法访问/api/**下的受保护接口（除登录 / 注册），由AuthInterceptor拦截验证。

整体来看，这是一个功能完整的 AI 聊天应用，整合了用户系统、AI 交互和前端展示，适合作为基础聊天助手的原型。这个项目是一个基于 Spring Boot 框架开发的 AI 聊天助手应用，主要功能是提供用户与 AI 模型的对话交互，并包含用户认证、聊天记录管理等功能。以下是项目的关键信息整理：
1. 技术栈
后端：Spring Boot、Spring AI（集成 Ollama AI 模型）、MyBatis（数据访问）、MySQL（数据库）。
前端：Vue.js、Element UI（UI 组件库）、Marked.js（Markdown 渲染）、Day.js（时间处理）。
AI 交互：通过 Ollama 调用本地部署的deepseek-r1:1.5b模型（配置在application.properties中）。
2. 核心功能
用户认证：支持用户登录、注册，通过AuthInterceptor拦截器实现接口权限控制（拦截/api/**路径，排除登录 / 注册接口），登录状态通过 Session 管理。
AI 对话：提供两种交互方式：
同步调用：通过/api/chat/call接口直接返回 AI 回答。
流式返回：通过/api/chat/stream接口以流的形式实时返回 AI 回答片段（适合长文本生成）。
聊天记录管理：保存用户与 AI 的对话记录到数据库，可通过/api/chat/list接口查询历史记录。
前端界面：提供聊天交互界面（chat.html），包含消息展示区、输入框、侧边栏（对话管理、设置等），支持 Markdown 格式渲染和消息时间显示。
3. 项目结构
后端核心目录：
com.example.controller：控制器（UserController处理用户相关，ChatController处理 AI 对话）。
com.example.service：业务逻辑（UserService用户服务、MessageService聊天记录服务）。
com.example.dto：数据传输对象（UserDto用户信息、MessageDto消息记录）。
com.example.config：配置类（WebMvcConfig注册拦截器）。
com.example.interceptor：拦截器（AuthInterceptor登录验证）。
前端资源：
静态页面（index.html主页面、chat.html聊天界面）。
CSS 样式（Element UI 相关样式文件）。
JS 脚本（Vue 实例、AI 对话逻辑、Markdown 渲染等）。
配置文件：application.properties配置数据库连接、Ollama 地址、MyBatis 映射等。
4. 数据存储
使用 MySQL 数据库（库名javaai），存储用户信息和聊天记录。
通过 MyBatis 的mapper接口（如UserMapper、消息相关 Mapper）操作数据库，支持下划线与驼峰命名转换。
5. 关键流程
用户登录 / 注册：通过/api/user/login或/api/user/register接口，验证成功后将用户信息存入 Session。
AI 对话：用户输入问题后，前端调用/api/chat/stream接口，后端通过 Ollama 模型生成回答，实时返回并保存对话记录。
权限控制：未登录用户无法访问/api/**下的受保护接口（除登录 / 注册），由AuthInterceptor拦截验证。
