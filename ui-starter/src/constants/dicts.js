const dictKinds = {
    STD_STATUS: 'dict_std_status',
    STD_BOOLEAN_DICT: 'std_boolean_dict',
    STD_YESNO_DICT: 'std_yesno_dict'
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
        ]
    }
}