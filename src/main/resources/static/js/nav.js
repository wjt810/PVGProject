var navs = [{
    "title": "后台首页",
    "icon": "icon-computer",
    "href": "page/main.html",
    "spread": false
}, {
    "title": "摄像机管理",
    "icon": "icon-text",
    "href": "cameraManager", // page/news/newsList.html
    "spread": false
}, {
    "title": "文章管理",
    "icon": "icon-text",
    "href": "page/links/linksList.html",
    "spread": false
}, {
    "title": "用户",
    "icon": "&#xe61c;",
    "href": "",
    "spread": false,
    "children": [
        {
            "title": "普通用户",
            "icon": "&#xe631;",
            "href": "page/user/Users.html",
            "spread": false
        }, {
            "title": "管理员",
            "icon": "&#xe631;",
            "href": "page/user/Admin.html",
            "spread": false
        }, {
            "title": "供应商",
            "icon": "&#xe631;",
            "href": "page/supplier/Supplier.html",
            "spread": false,
        }
    ]
}, {
    "title": "店铺",
    "icon": "&#xe631;",
    "href": "page/supplier/Supplier.html",
    "spread": false,
    "children": [
        {
            "title": "商品管理",
            "icon": "&#xe61c;",
            "href": "page/commodity/Commodity.html",
            "spread": false
        }, {
            "title": "订单详情",
            "icon": "&#xe631;",
            "href": "page/indent/Indent.html",
            "spread": "false",
        }
    ]
}
]