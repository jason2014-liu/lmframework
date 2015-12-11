此项目为一个快速开发平台

前台：jquery、jquery ui
后台：spring 3.1.1  + spring mvc 3.1.1  +  spring security 3.1.0  + jpa（hibernate3.6.0实现 ）


spring security 3.1.0
maven添加 core、config、web这三个包

bss: base service suit
实现功能：
1、用户登录注销
2、用户管理、角色管理、用户授权---spring security默认提供的表结构在文档中Appendix A. Security Database Schema 

用户、角色、模块、权限
users\roles\modules\authorities
用户角色关联
角色模块关联
角色权限关联
模块权限关联


用户登录后，角色模块关联表查模块（便于显示），模块和用户信息过滤在角色权限关联表查权限,权限资源关联表查菜单资源，用于显示

Spring Security is a framework that focuses on providing both authentication and authorization to Java applications.


layout: http://layout.jquery-dev.com/  jquery.layout.js