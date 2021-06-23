# 1、git使用记录

### 1、本地已经关联github的项目（此项目)如何推送到gitee?

首先用 常规关联远程仓库报错了，应该是找到github的对应仓库了

```lua
git remote add origin https://gitee.com/yang-ruyi/study.git
error: remote origin already exists.
```

然后用这个应该是创建了一个m分支关联了gitee

```lua
$ git remote add m https://gitee.com/yang-ruyi/study.git

```

然后查了一下资料，知道了下面的命令

        ```lua
        git remote -v  #查看本地关联
        m       https://gitee.com/yang-ruyi/study.git (fetch)
        m       https://gitee.com/yang-ruyi/study.git (push)
        origin  https://github.com/yang-higher/study.git (fetch)
        origin  https://github.com/yang-higher/study.git (push)
        
        ```

最后,推送成功

```lua
git push m
```

## 2、git推送代码

##### ① git add .

##### ② git commit -m "提交描述"

##### ③ git push



