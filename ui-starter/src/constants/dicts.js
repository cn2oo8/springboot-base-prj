const dictKinds = {
  STD_STATUS: 'dict_std_status',
  STD_BOOLEAN_DICT: 'std_boolean_dict',
  STD_YESNO_DICT: 'std_yesno_dict',
  STD_PLATFORM_DICT: 'std_platform_dict',
  STD_FK_TYPE_DICT: 'std_fk_type_dict',
  acProject_type_DICT: 'acProject_type_DICT'
}

export default {
  dictKinds,
  dictData: {
    [dictKinds.STD_STATUS]: [{
      kind: dictKinds.STD_STATUS,
      itemKey: '1',
      'itemName': '正常',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'green'
    }, {
      kind: dictKinds.STD_STATUS,
      itemKey: '-1',
      'itemName': '删除',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 2,
      'cssType': 'red'
    }
    ],
    [dictKinds.STD_BOOLEAN_DICT]: [{
      kind: dictKinds.STD_BOOLEAN_DICT,
      itemKey: 'true',
      'itemName': '是',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'blue'
    }, {
      kind: dictKinds.STD_BOOLEAN_DICT,
      itemKey: 'false',
      'itemName': '否',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'green'
    }
    ],
    [dictKinds.STD_YESNO_DICT]: [{
      kind: dictKinds.STD_YESNO_DICT,
      itemKey: '1',
      'itemName': '是',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'blue'
    }, {
      kind: dictKinds.STD_YESNO_DICT,
      itemKey: '2',
      'itemName': '否',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'green'
    }
    ],
    [dictKinds.STD_PLATFORM_DICT]: [{
      kind: dictKinds.STD_PLATFORM_DICT,
      itemKey: '0',
      'itemName': '管理后台',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'green'
    }, {
      kind: dictKinds.STD_PLATFORM_DICT,
      itemKey: '1',
      'itemName': '大客户',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'blue'
    }, {
      kind: dictKinds.STD_PLATFORM_DICT,
      itemKey: '2',
      'itemName': '分销',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'green'
    }, {
      kind: dictKinds.STD_PLATFORM_DICT,
      itemKey: '3',
      'itemName': '新通路',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'green'
    },
    {
      kind: dictKinds.STD_PLATFORM_DICT,
      itemKey: '4',
      'itemName': '医药城',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'green'
    },
    {
      kind: dictKinds.STD_PLATFORM_DICT,
      itemKey: '5',
      'itemName': '极光',
      'parentKind': '',
      'parentKey': '',
      'sortNum': 1,
      'cssType': 'green'
    }
    ],
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
    ]
  }
}
