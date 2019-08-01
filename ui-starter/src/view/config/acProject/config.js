/**
 * 此配置文件，请将请求urls放置到常量里面，方便使用。 如： src/constants/urls.js
 * dicts请放置到字典项配置常量里面，方便公用使用。 如：src/constants/dicts.js
 * 相关示例，可以参考
 https://github.com/cn2oo8/iview-admin/tree/d_20190525_clean_more 相关改造；需要使用到组件也可以从该分支获取。
 */
export default {
  urls: {
    'config': {
      'acProject': {
        'list': '/config/acProject/list',
        'add': '/config/acProject/add',
        'update': '/config/acProject/update',
        'delete': '/config/acProject/delete'
      }
    }
  },
  dicts: {
    'acProject_type_DICT': [
      {
        'itemName': '本地',
        'kind': 'acProject_type_DICT',
        'sortNum': 1,
        'itemKey': '1',
        'cssType': 'default'
      },
      {
        'itemName': '仓库',
        'kind': 'acProject_type_DICT',
        'sortNum': 2,
        'itemKey': '2',
        'cssType': 'default'
      }
    ],
    'acProject_status_DICT': [
      {
        'itemName': '有效',
        'kind': 'acProject_status_DICT',
        'sortNum': 1,
        'itemKey': '1',
        'cssType': 'default'
      },
      {
        'itemName': '无效',
        'kind': 'acProject_status_DICT',
        'sortNum': 2,
        'itemKey': '-1',
        'cssType': 'default'
      }
    ]
  }
}
