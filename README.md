# AI Chat Web Application

一个基于Spring Boot和AI技术的聊天Web应用程序，支持与AI进行文本对话、图像生成和语音合成功能。

## 项目介绍

本项目是一个集成了AI功能的聊天应用，用户可以通过注册登录后与AI进行交互。项目使用了多种AI技术，包括文本对话、图像生成和语音合成，为用户提供丰富的交互体验。

## 技术栈

- 后端框架：Spring Boot 3.4.9
- 数据库：MySQL
- 持久层框架：MyBatis
- AI技术：
  - 文本对话：Ollama + DeepSeek模型
  - 阿里云百炼平台API
  - 图像生成：Spring AI Image Model
  - 语音合成：DashScope语音合成
- 前端技术：
  - Vue.js
  - Element UI
  - HTML/CSS/JavaScript

## 功能特性

1. 用户注册和登录系统
2. 实时聊天功能
3. AI文本对话（支持流式响应）
4. 聊天历史记录保存
5. 图像生成功能
6. 文本转语音功能
7. 响应式用户界面

## 环境要求

- Java 17+
- Maven 3.6+
- MySQL 5.7+
- Ollama服务（本地部署）
- 网络连接（用于访问阿里云百炼平台API）

## 安装和配置

### 1. 克隆项目

```bash
git clone <项目地址>
cd demo
```

### 2. 数据库配置

在MySQL中创建数据库：

```sql
CREATE DATABASE javaai;
```

修改 `src/main/resources/application.properties` 中的数据库配置：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/javaai
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. AI服务配置

#### Ollama配置

1. 安装并启动 [Ollama](https://ollama.com/)
2. 拉取模型：
   ```bash
   ollama pull deepseek-r1:1.5b
   ```
3. 确保 `application.properties` 中配置正确：
   ```properties
   spring.ai.ollama.base-url=http://localhost:11434
   spring.ai.ollama.chat.model=deepseek-r1:1.5b
   ```

#### 阿里云百炼平台配置

1. 在[阿里云百炼平台](https://help.aliyun.com/zh/bailian)获取API Key
2. 修改 `application.properties` 中的API Key：
   ```properties
   spring.ai.dashscope.api-key=your_api_key_here
   ```

### 4. 构建和运行

使用Maven构建项目：

```bash
mvn clean install
```

运行应用：

```bash
mvn spring-boot:run
```

或者打包后运行：

```bash
mvn package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## 使用说明

1. 访问 `http://localhost:8080/login.html` 进入登录页面
2. 新用户需要先注册账号
3. 登录后进入聊天界面，可以与AI进行对话
4. 支持文本对话、图像生成和语音合成功能

## 项目结构

```
src/
├── main/
│   ├── java/com/example/
│   │   ├── annotation/       # 自定义注解
│   │   ├── config/           # 配置类
│   │   ├── controller/       # 控制器
│   │   ├── dto/              # 数据传输对象
│   │   ├── exception/        # 异常处理
│   │   ├── interceptor/      # 拦截器
│   │   ├── mapper/           # MyBatis映射器
│   │   ├── service/          # 业务逻辑层
│   │   └── DemoApplication.java  # 应用启动类
│   └── resources/
│       ├── mapper/           # MyBatis XML映射文件
│       ├── static/           # 静态资源文件
│       └── application.properties  # 应用配置文件
└── test/                     # 测试代码
```

## 主要API接口

- 用户相关：
  - POST `/api/user/login` - 用户登录
  - POST `/api/user/register` - 用户注册

- 聊天相关：
  - POST `/api/chat/call` - AI文本对话
  - POST `/api/chat/stream` - AI流式文本对话
  - POST `/api/chat/list` - 获取聊天历史记录
  - POST `/api/chat/image` - 图像生成
  - POST `/api/chat/speech` - 语音合成

## 注意事项

1. 确保Ollama服务在本地运行并可访问
2. 确保数据库服务正常运行
3. 阿里云API Key需要有效且有足够额度
4. 语音合成和图像生成功能需要网络连接

## 许可证

本项目仅供学习和参考使用。