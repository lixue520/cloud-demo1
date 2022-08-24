# CSS样式基础

##### 1.1CSS的选择器

- 标签选择器

  ```css
    <style>
        body {
          background-color: deepskyblue;
          color: floralwhite;
        }
        h1 {
          text-align: center;
        }
      </style>
  ```

- 类选择器

  ```css
     <style>
        .book {
          color: lightskyblue;
        }
      </style>
  ```

  

- id选择器

  ```css
     <style>
        #book {
          color: lightskyblue;
        }
      </style>
  ```

  

- 选择器优先级:**id 选择器 > 类选择器 > 标签选择器**。

- ！important

  ```html
  <!DOCTYPE html>
  <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>Document</title>
      <style>
        #idSelector {
          color: rgb(48, 179, 202);
        }
        .classSelector {
          color: rgb(102, 160, 76);
        }
        p {
            
          color: rgb(123, 52, 133) !important;   //使得优先级最高
        }
      </style>
    </head>
    <body>
      <p id="idSelector" class="classSelector">蓝桥云课</p>
    </body>
  </html>
  ```

- 后代选择器

  ```css
  <style>
        #paragraph p {           //只有该id为其号的子元素为p才被渲染
          color: lightskyblue;
        }
  </style>
  ```

  

- 群组选择器

  ```css
  <style>
        div,        //与其同级的div和span均被渲染
        span {
          color: lightskyblue;
        }
   </style>
  ```

- 应用

  ```css
  <!DOCTYPE html>
  <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>Document</title>
      <style>
          h1{
            text-align: center;
          }
          .test{
            color:brown;
          }
          .ppj ul li {
            color:aquamarine;
          }
      </style>
    </head>
    <body>
      <h1>图书屋</h1>
      <h2 class="test">图书分类</h2>
      <div class="ppj">
         <ul>
        <li>小说</li>
        <li>文艺</li>
        <li>励志</li>
        <li>童书</li>
        <li>生活</li>
      </ul>
      </div>
    </body>
  </html>
  ```

  ![image-20220817160201817](C:\Users\qin\AppData\Roaming\Typora\typora-user-images\image-20220817160201817.png)

##### 1.2CSS常用样式

###### 1.2.1 背景样式

```html
 <style>
      body {
        background-image: url("moon.jpg");
        background-size: 300px 300px;
        background-position: center;  //改变背景图片位置
      }
      body {
        background-image: url("moon.jpg");
        background-size: 300px 300px;
        background-repeat: no-repeat;   //背景图像仅显示一次
          repeat:垂直和水平方向重复(以下为可选/此为默认)
          repeat-x
          repeat-y
          no-repeat
      }
 </style>
```



###### 1.2.2 CSS文本属性

| 属 性           | 可 取 值                                              | 描 述                              |
| --------------- | ----------------------------------------------------- | ---------------------------------- |
| line-height     | normal、number、length、%                             | 设置行高                           |
| text-indent     | length、%                                             | 设置文本缩进                       |
| text-align      | left、right、center、justify、start、end              | 设置对齐方式                       |
| letter-spacing  | normal、length                                        | 设置字符间距                       |
| text-decoration | line、color、style、thickness                         | 设置文本修饰                       |
| white-space     | normal、pre、nowrap、pre-wrap、pre-line、break-spaces | 规定如何处理空白                   |
| line-break      | auto、loose、normal、strict、anywhere、unset          | 处理如何断开带有标点符号的文本的行 |

###### 1.2.3 CSS文字的使用

| 属 性       | 可 取 值                                                     | 描 述                          |
| ----------- | ------------------------------------------------------------ | ------------------------------ |
| font        | font-style、font-variant、font-weight、font-size（或 line-height）、font-family | 在一个声明中设置所有的字体属性 |
| font-family | 字体名称、inherit                                            | 设置字体类型                   |
| font-size   | xx-small、x-small、small、medium（默认）、large、x-large、xx-large smaller、larger length、%、inherit | 设置字体大小                   |
| font-weight | normal（默认）、bold、bolder、lighter、inherit 100、200…900（400=normal，700=bold） | 设置字体粗细                   |
| font-style  | normal、italic、oblique、inherit                             | 设置字体风格                   |

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      h3 {
        font-size: 20px;
        font-family: 隶书;
        line-height: 28px;
      }
      span {
        font: italic 16px 华文彩云;
      }
    </style>
  </head>
  <body>
    <h3>Web 前端技术</h3>
    <span
      >在当今社会中，Web 已经成为网络信息共享和发布的主要形式。要想开发 Web 应用
      系统，就必须掌握 Web 前端技术。</span
    >
  </body>
</html>
```



###### 1.2.4 链接中的伪类

在 CSS 中，伪类是添加到选择器的关键字，给指定元素设置一些特殊状态，我们以 `:` 开头。

链接有以下四个状态。这四种状态也称之为超链接的伪类。

| 状态      | 效果                     |
| --------- | ------------------------ |
| a:link    | 普通的、未被访问的链接。 |
| a:hover   | 鼠标指针位于链接的上方。 |
| a:active  | 链接被单击的时刻。       |
| a:visited | 用户已访问的链接。       |

针对超链接的上述四种状态设置样式规则，能起到美化超链接的作用。例如，为了完成下对超链接的显示要求，编写的 CSS 样式代码如下。

| 状 态    | 颜 色 | 背 景 色 | 文 本 修 饰 |
| -------- | ----- | -------- | ----------- |
| 未访问   | 蓝色  | 无       | 无下画线    |
| 鼠标移到 | 黑色  | #DDDDDD  | 下画线      |
| 正单击   | 红色  | #AAAAAA  | 删除线      |
| 已访问   | 绿色  | 无       | 无下画线    |

> 对于超链接的伪类，我们推荐的使用顺序是：:link - :visited - :hover - :active。

###### 1.2.5 列表样式

| 属 性               | 可 取 值                                               | 描 述                          |
| ------------------- | ------------------------------------------------------ | ------------------------------ |
| list-style          | list-style-type、list-style-position、list-style-image | 在一个声明中设置所有的列表属性 |
| list-style-image    | URL、none                                              | 设置图像为列表项标志           |
| list-style-position | inside、outside、inherit                               | 设置列表中列表项标志的位置     |
| list-style-type     | disc（默认）、circle、square、decimal 等               | 设置列表项标志的类型           |

##### 1.3CSS盒子模型

###### 1.3.1 border-style

- top

- right

- bottom

- left

  ```css
  <style>
        p {
          border-top-style: solid;   //给上边框设置样式：固体
          border-right-style: dotted;  //点线
          border-bottom-style: dashed; //虚线
          border-left-style: double;  //双线
        }
  </style>
  ```

  ![img](https://doc.shiyanlou.com/courses/uid1347963-20210323-1616469838836)

###### 1.3.2 border-width

```css
 <style>
      p1 {
        border-style: solid;
        border-top-width: thin;
        border-right-width: medium;
        border-bottom-width: thick;
        border-left-width: 6px;
      }
      p2 {
        width: 420px;
        height: 200px;
        border: 1px solid;
        border-top-color: red;
        border-right-color: green;
        border-bottom-color: blue;
        border-left-color: yellow;
      }
  </style>
```



###### 1.3.3 border 和padding（内边距）

```html
<!DOCTYPE html>
<html>
  <head>
    <style>
      p {
        border-top: thin solid red;
        border-right: medium dotted green;
        border-bottom: dashed thick blue;
        border-left: double 6px yellow;
        padding: 10px;   //内填充即在border边界与内容区的距离（填充内边距）
      }
    </style>
  </head>
  <body>
    <p>
      在当今社会中，Web已经成为网络信息共享和发布的主要形式。
      要想开发Web应用系统，就必须掌握前端技术。
      本书从HTML、CSS和JavaScript三个方面系统地介绍了Web前端开发。
    </p>
  </body>
</html>
```



###### 1.3.4 margin 属性的使用（外边距）

```css
p{
    margin:上 右 下 左
    margin:上 左右 下
    margin: 上下、左右
    margin: 属性值
        margin-top: 属性值;
        margin-left: 属性值;
        margin-right: 属性值;
        margin-bottom: 属性值;
}
```

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      div {
        width: 200px;
        height: 100px;
        border: 1px solid blue;
      }
       p {
      width: 100px;
      height: 50px;
      background-color: darkgrey;
      text-align: center;
      margin: 25px 50px;
    }
    </style>
  </head>
  <body>
    <div>
      <p>蓝桥云课</p>
    </div>
  </body>
</html>
```

![img](https://doc.shiyanlou.com/courses/3773/1347963/aa1ea69fb4819fd40235edab0ad2f126-0)

###### 1.3.5 display属性的使用

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      span {
        display: block;  //将行内元素编程块级元素；并列==>并行
          inline  //以内联方式
          inline-block //内敛块
          none  //隐藏块
      }
    </style>
  </head>
  <body>
    <span>蓝桥</span><span>云课</span>
  </body>
</html>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      a {
        text-decoration: none;
        background-color: rgb(95, 118, 160);
        display: inline-block;   //内敛块 //将其变成一行的元素（内联）+变成块级
        width: 70px;
        height: 30px;
        text-align: center;
      }
    </style>
  </head>
  <body>
    <a href="#">首页</a>
    <a href="#">分类</a>
    <a href="#">展示</a>
    <a href="#">更多</a>
  </body>
</html>
```



##### 1.4CSS定位

###### 1.4.1固定定位

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      .box {
        width: 100%;
        margin-left: 15%;
      }
      .ad-l {
        position: fixed;
        top: 100px;
        left: 0;
      }
      .ad-r {
        position: fixed;
        top: 100px;
        right: 0;
      }
    </style>
  </head>
  <body>
    <img src="ad-l.png" class="ad-l" />
    <img src="ad-r.png" class="ad-r" />
    <div class="box">
      <img src="box.png" />
    </div>
  </body>
</html>
```

![image-20220817180134300](C:\Users\qin\AppData\Roaming\Typora\typora-user-images\image-20220817180134300.png)

###### 1.4.2相对定位

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      .box {
        width: 100%;
      }
      .ad-l {
        /* position: relative; */
/* 
        left: -40px; */   相对默认的就是原来的位置向左边移动了-40px的距离
      }
      .ad-r {
        /* position: relative; */

        /* left: 100px; */
      }
    </style>
  </head>
  <body>
    <img src="ad-l.png" class="ad-l" />
    <img src="ad-r.png" class="ad-r" />
    <div class="box">
      <img src="box.png" />
    </div>
  </body>
</html>
```



###### 1.4.3绝对定位

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      .box {
        width: 100%;
        margin-left: 180px;
      }
      .ad-l {
        position: absolute;  //精准的放在浏览器的位置上;不随浏览器的上下移动而变动相对（区别固定定位）
        left: 50px;
        top: 150px;
      }
      .ad-r {
        position: absolute;
        right: 30px;
        top: 150px;
      }
    </style>
  </head>
  <body>
    <img src="ad-l.png" class="ad-l" />
    <img src="ad-r.png" class="ad-r" />
    <div class="box">
      <img src="box.png" />
    </div>
  </body>
</html>
```



##### 1.5完成基本布局（蓝桥航天知识站响应布局）



# CSS3入门

##### 2.1 CSS3选择器

###### 2.1.1 新增属性选择器

| 选择器        | 描述                                                        |
| ------------- | ----------------------------------------------------------- |
| E[attr^=“xx”] | 选择元素 E，其中 E 元素的 attr 属性是以 xx 开头的任何字符。 |
| E[attr$=“xx”] | 选择元素 E，其中 E 元素的 attr 属性是以 xx 结尾的任何字符。 |
| E[attr*=“xx”] | 选择元素 E，其中 E 元素的 attr 属性是包含 xx 的任何字符。   |

```css
<style>
      a[href^="#"] {
        color: rgb(179, 255, 0);
      }
      a[href$="org"] {
        color: rgb(195, 0, 255);
      }
      a[href*="un"] {
        background-color: rgb(0, 255, 149);
        color: white;
      }
</style>
```



###### 2.1.2 子元素伪类选择器

子元素伪类选择器就是选择某元素的子元素的一种选择器。

在 CSS3 中，有以下几种子元素伪类选择器：

| 选择器                | 描述                                                         |
| --------------------- | ------------------------------------------------------------ |
| E:first-child         | 选择元素 E 的第一个子元素。                                  |
| E:last-child          | 选择元素 E 的最后一个子元素。                                |
| E:nth-child(n)        | 选择元素 E 的第 n 个子元素，n 有三种取值，数字、odd 和 even。注意第一个子元素的下标是 1。 |
| E:only-child          | 选择元素 E 下唯一的子元素。                                  |
| E:first-of-type       | 选择父元素下第一个 E 类型的子元素。                          |
| E:last-of-type        | 选择父元素下最后一个 E 类型的子元素。                        |
| E:nth-of-type(n)      | 选择父元素下第 n 个 E 类型的子元素，n 有三种取值，数字、odd 和 even。 |
| E:only-of-type        | 选择父元素唯一的 E 类型的子元素。                            |
| E:nth-last-child(n)   | 选择所有 E 元素倒数的第 n 个子元素。                         |
| E:nth-last-of-type(n) | 选择所有 E 元素倒数的第 n 个为 E 的子元素。                  |

###### 2.1.3 UI伪类选择器

UI 伪类选择器是通过元素的状态来选择的一种选择器。

在 CSS3 中有以下几种 UI 伪类选择器。

| 选择器      | 描述                                 |
| ----------- | ------------------------------------ |
| :focus      | 给获取焦点的元素设置样式。           |
| ::selection | 给页面中被选中的文本内容设置样式。   |
| :checked    | 给被选中的单选框或者复选框设置样式。 |
| :enabled    | 给可用的表单设置样式。               |
| :disabled   | 给不可用的表单设置样式。             |
| :read-only  | 给只读表单设置样式。                 |
| :read-write | 给可读写的表单元素设置样式。         |
| :valid      | 验证有效。                           |
| :invalid    | 验证无效。                           |

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      /*格式错误*/
      input:invalid {
        background-color: red;
      }
      /*格式正确*/
      input:valid {
        background-color: green;
      }
    </style>
  </head>
  <body>
    电子邮箱：<input type="email" />
  </body>
</html>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      input:focus {
        background-color: rgb(255, 153, 0);
      }
    </style>
  </head>
  <body>
    姓名：<input type="text" /><br />
    密码：<input type="password" />
  </body>
</html>
```



###### 2.1.4 五彩导航

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
       
        div  a{
            color: #fff;
            text-decoration: none; 
            border-radius: 30%;
            background-color: blue;
            display: inline-block;
        }

        .pp:focus{
            background-color: red;
        }

        .pp1:focus{
            background-color: goldenrod; 
        }

        a:focus{
            background-color: black;  //没被覆盖的默认
        }
    
    </style>
  </head>
  <body>
    <div>
       <a href="" class="pp">导航一</a> //被红色覆盖
       <a href="" class="pp1">导航二</a>
       <a href="">导航三</a>
       <a href="">导航四</a>
       <a href="">导航五</a>
    </div>
  </body>
</html>
```

![image-20220817205332768](C:\Users\qin\AppData\Roaming\Typora\typora-user-images\image-20220817205332768.png)

##### 2.2 CSS3新增特效

###### 2.2.1 文本阴影

```html
文本阴影的语法格式如下：

text-shadow: x-offset y-offset blur color;
copy
x-offset 是沿 x 轴方向的偏移距离，允许负值，必须参数。
y-offset 是沿 y 轴方向的偏移距离，允许负值，必须参数。
blur 是阴影的模糊程度，可选参数。
color 是阴影的颜色，可选参数
```



###### 2.2.2 @font-face下载字体

@font-face 的作用就是从网上下载并使用自定义字体，使页面显示字体不依赖用户的操作系统字体环境。

```css
 @font-face {
        font-family: "Source Han Serif SC";
        src: url("https://labfile.oss.aliyuncs.com/courses/3773/SourceHanSerifSC-Heavy.otf");
      }
```



###### 2.2.3 艺术文本

###### 2.2.4 word-break属性

其语法为：

```css
word-break: normal|break-all|keep-all;
```

取值说明：

| 值        | 描述                           |
| --------- | ------------------------------ |
| normal    | 使用浏览器默认的换行规则。     |
| break-all | 允许在单词内换行。             |
| keep-all  | 只能在半角空格或连字符处换行。 |

![img](https://doc.shiyanlou.com/courses/uid1347963-20210324-1616572811540)

###### 2.2.5 work-wrap属性容器文本换行

`word-wrap` 属性是用来强制换行的。

```css
<style>
      div {
        width: 100px;
        border: 1px solid rgb(0, 140, 255);
        word-wrap: break-word;
      }
</style>
```

`word-break` 属性也是用来强制换行的。

###### 2.2.6 文本溢出

`text-overflow` 属性可以设置超长文本省略显示，其语法如下所示：

```css
text-overflow: clip|ellipsis;
```

其属性值的含义如下所示：

| 属性值   | 描述                             |
| -------- | -------------------------------- |
| clip     | 修剪文本。                       |
| ellipsis | 显示省略符号来代表被修剪的文本。 |

###### 2.2.7 圆角边框

在 CSS3 中，使用 `border-radius` 属性来设置圆角边框。

`border-radius` 属性的值表示圆角的直径，可以设置四个值，其值的顺序为：左上角，右上角，右下角，左下角。

其语法格式为：

```css
border-radius: 取值;
```

我们也可以分开设置四个角的属性值，语法如下所示：

```css
border-top-left-radius: 取值;
border-top-right-radius: 取值;
border-bottom-right-radius: 取值;
border-bottom-left-radius: 取值;
```

![img](https://doc.shiyanlou.com/courses/uid1347963-20210324-1616580578515)

###### 2.2.8 边框颜色

```HTML
 <style>
      div {
        width: 150px;
        height: 150px;
        border-style: solid;
        border-color: rgb(208, 255, 0) rgb(0, 255, 128) rgb(255, 0, 179) rgb(
            0,
            217,
            255
          );
      }
    </style>
```

![img](https://doc.shiyanlou.com/courses/uid1347963-20210325-1616635980069)

###### 2.2.9 边框阴影

`box-shadow` 属性可以用来设置一个或多个下拉阴影的框，视觉效果就像是盒子有了阴影一样。

其语法格式为：

```css
box-shadow: h-shadow v-shadow blur spread color inset;
```

其属性值的意义如下所示：

| 值       | 说明                             |
| -------- | -------------------------------- |
| h-shadow | 必选，水平阴影的位置，允许负值。 |
| v-shadow | 必选，垂直阴影的位置，允许负值。 |
| blur     | 可选，模糊距离。                 |
| spread   | 可选，阴影的大小。               |
| color    | 可选，阴影的颜色。               |
| inset    | 可选，将外部阴影改为内部阴影。   |

```HTML
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      div {
        width: 100px;
        height: 100px;
        border: 1px solid steelblue;
        border-radius: 100%;
        box-shadow: 5px 5px 10px seagreen;
      }
    </style>
  </head>
  <body>
    <div></div>
  </body>
</html>
```

![img](https://doc.shiyanlou.com/courses/3773/1347963/cd544fffe354af5a35273d2ebe950d91-0)

###### 2.2.10 图片边框

###### 2.2.11 立体导航

###### 2.2.12 背景图尺寸

```HTML
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      div {
        padding: 30px;
        background-image: url("icons8-seedling-96.png");
        background-repeat: no-repeat;
        background-position: left;
        background-size: 50px 50px;   //背景尺寸
      }
      .content1 {
        border: 1px solid rgb(13, 110, 73);
        width: 300px;
        height: 150px;
        background-origin: border-box; /*图片显示在边框处*/   //背景位置区域
      }
      .content2 {
        border: 1px solid rgb(13, 110, 73);
        width: 300px;
        height: 150px;
        margin-top: 20px;
        background-origin: content-box; /*图片显示在内容里*/
      }
    </style>
  </head>
  <body>
    <div class="content1">
      春华沧江月，秋色碧海云。离居盈寒暑，对此长思君。
      思君楚水南，望君淮山北。梦魂虽飞来，会面不可得。
      畴昔在嵩阳，同衾卧羲皇。绿萝笑簪绂，丹壑贱岩廊。
      晚途各分析，乘兴任所适。仆在雁门关，君为峨眉客。
    </div>
    <div class="content2">
      心悬万里外，影滞两乡隔。长剑复归来，相逢洛阳陌。
      陌上何喧喧，都令心意烦。迷津觉路失，托势随风翻。
      以兹谢朝列，长啸归故园。故园恣闲逸，求古散缥帙。
      久欲入名山，婚娶殊未毕。人生信多故，世事岂惟一。
    </div>
  </body>
</html>
```



###### 2.2.13背景剪裁

`background-clip` 属性是用来定义背景图像裁剪区域的。

其语法格式为：

```css
background-clip: border-box|padding-box|content-box;
```

其属性值的意义如下所示：

| 值          | 说明                                             |
| ----------- | ------------------------------------------------ |
| border-box  | 默认值，背景绘制在边框方框内（剪切成边框方框）。 |
| padding-box | 背景绘制在衬距方框内（剪切成衬距方框）。         |
| content-box | 背景绘制在内容方框内（剪切成内容方框）。         |

举个例子来看看吧～ 😉

新建一个 `index.html` 文件，在其中写入以下内容。

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      div {
        border: 15px double #83a95c;
        padding: 30px;
        color: black;
        background: #d6efc7;
      }
      #content2 {
        background-clip: padding-box; /*背景绘制在 padding 区域*/
      }
      #content3 {
        background-clip: content-box; /*背景绘制在内容区域*/
      }
    </style>
  </head>
  <body>
    <div id="content1">
      春华沧江月，秋色碧海云。离居盈寒暑，对此长思君。
      思君楚水南，望君淮山北。梦魂虽飞来，会面不可得。
      畴昔在嵩阳，同衾卧羲皇。绿萝笑簪绂，丹壑贱岩廊。
      晚途各分析，乘兴任所适。仆在雁门关，君为峨眉客。
    </div>
    <br/>
    <div id="content2">
      心悬万里外，影滞两乡隔。长剑复归来，相逢洛阳陌。
      陌上何喧喧，都令心意烦。迷津觉路失，托势随风翻。
      以兹谢朝列，长啸归故园。故园恣闲逸，求古散缥帙。
      久欲入名山，婚娶殊未毕。人生信多故，世事岂惟一。
    </div>
    <br/>
    <div id="content3">
      念此忧如焚，怅然若有失。闻君卧石门，宿昔契弥敦。
      方从桂树隐，不羡桃花源。高风起遐旷，幽人迹复存。
      松风清瑶瑟，溪月湛芳樽。安居偶佳赏，丹心期此论。
    </div>
  </body>
</html>
```

点击预览页面，实验效果如下：

![图片描述](https://doc.shiyanlou.com/courses/3773/1693782/0f5891c0b1769c5be30af371793fcde1-0)

###### 2.2.14 多图背景

在 CSS3 中，background-image 属性的属性值可以包含多个图片的地址。语法如下：

```css
/*图片地址*/
background-image: url(), url(), ..., url();
```

若想让图片放在我们想要的位置，可以使用 background-position 属性设置图片显示的位置。语法如下：

```css
/*图片显示的位置*/
background-position: position1, position2, ..., positionN;
```

若想要设置图片是否重复显示在页面上，我们可以添加 background-repeat 属性。语法如下：

```css
/*图片是否重复*/
background-repeat: repeat1, repeat2, ..., repeatN;
```

举个例子来看看吧～ 😉

使用以下命令获取所需的图片。

```bash
wget https://labfile.oss.aliyuncs.com/courses/3429/icons8-rat-96.png

wget https://labfile.oss.aliyuncs.com/courses/3429/nemuel.jpg
```

新建一个 `index.html` 文件，在其中写入以下内容。

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      #content1 {
        /*小图片来自 icons*/
        background-image: url("icons8-rat-96.png"), url("nemuel.jpg");
        background-position: right bottom, left top; /*相对于父元素大小，老鼠图片右下角显示，大背景图片在左上角显示*/
        background-repeat: no-repeat, no-repeat; /*两张图片不重复*/
        padding: 15px;
        width: 400px;
        height: 260px;
      }
    </style>
  </head>
  <body>
    <div id="content1"></div>
  </body>
</html>
```

点击预览页面，效果如下：

![图片描述](https://doc.shiyanlou.com/courses/uid1347963-20210325-1616640698390)

###### 2.2.15 RBG颜色

RGBA 色彩模式是 RGB 色彩模式的扩展，在 `Red`（红）、`Green`（绿）、`Blue`（蓝）三原色通道的基础上，增加了 `alpha`（明度）参数，这样设置让颜色的设置变得更加合理和便捷。

其语法格式为：

```css
rgba(r,g,b,<opacity>)
```

其中，`rgb` 的颜色取值范围为 `0～255`，`opacity` 的取值范围为 `0~1`。若是输入值超过取值范围，浏览器会将数值调整到最近的可取值。

我们举个例子来看看～ 😉

新建一个 `index1.html` 文件，在其中写入以下内容。

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      li {
        width: 100px;
        list-style: none;
      }
      ul {
        float: left;
        margin-left: 40px;
      }
      li.opacity1 {
        opacity: 1;
        background: red;
      }
      li.opacity2 {
        opacity: 0.8;
        background: red;
      }
      li.opacity3 {
        opacity: 0.6;
        background: red;
      }
      li.opacity4 {
        opacity: 0.4;
        background: red;
      }
      li.opacity5 {
        opacity: 0.2;
        background: red;
      }
      li.opacity6 {
        opacity: 0;
        background: red;
      }
      li.rgba1 {
        background: rgba(255, 0, 0, 1);
      }
      li.rgba2 {
        background: rgba(255, 0, 0, 0.8);
      }
      li.rgba3 {
        background: rgba(255, 0, 0, 0.6);
      }
      li.rgba4 {
        background: rgba(255, 0, 0, 0.4);
      }
      li.rgba5 {
        background: rgba(255, 0, 0, 0.2);
      }
      li.rgba6 {
        background: rgba(255, 0, 0, 0);
      }
    </style>
  </head>
  <body>
    <ul>
      <li>opacity 效果</li>
      <li class="opacity1">100%</li>
      <li class="opacity2">80%</li>
      <li class="opacity3">60%</li>
      <li class="opacity4">40%</li>
      <li class="opacity5">20%</li>
      <li class="opacity6">0</li>
    </ul>
    <ul>
      <li>rgba 效果</li>
      <li class="rgba1">1</li>
      <li class="rgba2">0.8</li>
      <li class="rgba3">0.6</li>
      <li class="rgba4">0.4</li>
      <li class="rgba5">0.2</li>
      <li class="rgba6">0</li>
    </ul>
  </body>
</html>
```

点击预览页面，实验效果如下：

![图片描述](https://doc.shiyanlou.com/courses/uid1347963-20210325-1616651191492)



##### 2.3 CSS 2D和3D转换

##### 2.4 CSS3 过渡

##### 2.5 CSS3动画

##### 2.6 CSS3弹性盒子

##### 2.7 媒体查询

