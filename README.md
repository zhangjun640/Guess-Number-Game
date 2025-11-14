
# README.md

# Guess Number Game (猜数字)

A classic **Bulls and Cows (nA nB)** game implemented in **Java Swing**, featuring user accounts, score ranking, custom UI components, and local data persistence.



---

##  Features

###  Bulls and Cows (nAnB)
- 系统生成 **4位不重复数字**
- **nA**: 数字 + 位置都正确  
- **nB**: 数字正确但位置错误  

###  User System
- 用户 **注册 / 登录**
- 用户信息写入 `Message.txt`（通过 `~` 分隔）
- 持久化本地文件保存账号密码

###  Score & Ranking
- 每次猜对（4A）分数 +1
- 排行榜界面展示所有用户得分
- 排行榜持久化文件：`Rank.txt`

###  Custom UI
自定义 Swing 组件：
- `CustomButton`
- `CustomTextField`
- `CustomTextArea`

自定义背景图：  
`Start.java`、`Game.java` 内使用背景图片作为界面元素。

###  Multi-window Management
- `run.java`: 程序启动器 + 窗口管理  
- `ActMenu.java`: 游戏中快速跳转菜单（新用户 / 排行榜 / 新数字）

---

##  Tech Stack

- **Language:** Java  
- **UI:** Java Swing  
- **Encoding:** GB2312  
- **Data Storage:** 本地 `.txt` 文件  
- **IDE Recommended:** IntelliJ IDEA  

---

##  Installation & Run

### 1. Install Java
需要 JDK 8 或更高版本。

### 2. Fix Image Paths (**Important!**)
代码中使用了绝对路径，请将其修改为相对路径，例如：

在 `Start.java`：
```

new CustomButton("...", "image1.jpg")

```

在 `Game.java`：
```

createBackgroundPanel("image.png")

````

确保图片在项目根目录。

---

##  Build Instructions

###  使用 IntelliJ IDEA
- 直接打开项目
- Build Project
- 运行 `run.java`

###  使用命令行

```bash
# 创建输出目录
mkdir out

# 编译（使用 GB2312 编码）
javac -encoding GB2312 -d out -cp src src/*.java

# 进入输出目录
cd out

# 运行主类
java run
````

程序运行后会在项目根目录自动创建：

* `Message.txt`
* `Rank.txt`

---

## 📂 Project Structure

```
.
├── src/
│   ├── run.java
│   ├── Start.java
│   ├── Game.java
│   ├── Rank.java
│   ├── Login.java
│   ├── Register.java
│   ├── Guess.java
│   ├── Client.java
│   ├── Check.java
│   ├── UserMessage.java
│   ├── ActMenu.java
│   ├── CustomButton.java
│   ├── CustomTextField.java
│   └── CustomTextArea.java
│
├── Message.txt
├── Rank.txt
├── image.png
├── image1.jpg
└── README.md
```

---

## 📸 Screenshots

（示例占位）

```
![Start Screen](image.png)
```

---

## 📝 License

This project is released as open-source. You may modify, distribute, and study the source code freely.

---

## 🤝 Contributing

Pull requests are welcome!
If you encounter a bug or want a new feature, feel free to open an issue.

```

随时告诉我！
```
