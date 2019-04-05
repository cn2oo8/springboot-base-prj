/**
 * 抽取出来方便
 */
import * as renderUtil from '@/libs/renderUtil.js';
import constants from '@/constants/constants';
import operate from './operate.vue';
import dictLabel from '@/views/common/dict/DictLabel';
import dictSelect from '@/views/common/dict/DictSelect';
import dictCheckbox from '@/views/common/dict/DictCheckBox';

const searchFormRules = {

};

const dictKinds = {
    LOCAL_LABEL_DICT: 'local_label_dict'
};
const localDicts = {
    dictKinds,
    dictData: {
        [dictKinds.LOCAL_LABEL_DICT]: [{
            kind: dictKinds.LOCAL_LABEL_DICT,
            itemKey: '1',
            'itemName': '标签1',
            'parentKind': '',
            'parentKey': '',
            'sortNum': 1,
            'cssType': 'blue'
        }, {
            kind: dictKinds.LOCAL_LABEL_DICT,
            itemKey: '2',
            'itemName': '标签2',
            'parentKind': '',
            'parentKey': '',
            'sortNum': 1,
            'cssType': 'red'
        }
        ]
    }
};

let tableDefine = {
    data () {
        return {
            loading: false,
            columns: [

                {
                    title: 'id',
                    key: 'id'
                },

                {
                    title: '名称',
                    key: 'name'
                },

                {
                    title: '项目key',
                    key: 'projectKey'
                },

                {
                    title: '类型',
                    render: (h, params) => {
                        return h(dictLabel, {
                            props: {
                                value: params.row['type'],
                                kind: constants.dicts.dictKinds.acProject_type_DICT,
                                showStyle: true
                            }
                        });
                    }
                },

                {
                    title: '扩展1',
                    key: 'ext1'
                },

                {
                    title: '扩展2',
                    key: 'ext2'
                },

                {
                    title: '扩展3',
                    key: 'ext3'
                },

                {
                    title: '创建人',
                    key: 'creator'
                },

                {
                    title: '修改人',
                    key: 'operator'
                },

                {
                    title: '并发版本号',
                    key: 'concurrentVersion'
                },

                {
                    title: '数据版本',
                    key: 'dataVersion'
                },

                {
                    title: '状态',
                    render: (h, params) => {
                        return h(dictLabel, {
                            props: {
                                value: params.row['status'],
                                kind: constants.dicts.dictKinds.acProject_status_DICT,
                                showStyle: true
                            }
                        });
                    }
                },

                {
                    title: '修改时间',
                    key: 'modified',
                    render: (h, params) => {
                        return h('div', renderUtil.formatDateTime(params.row.modified));
                    }
                },

                {
                    title: '操作',
                    key: 'action',
                    width: 250,
                    align: 'center',
                    render: (h, params) => {
                        return h(operate, {
                            props: {
                                item: params.row
                            },
                            on: {
                                'refreshList': () => {
                                    this.loadData();
                                },
                                'updateItem': (item) => {
                                    this.editItem(item);
                                }
                            }
                        });
                    }
                }
            ],
            queryResult: {
                dataList: [],
                pageQuery: {
                    totalCount: 0,
                    pageCount: 0,
                    pageNo: 1,
                    pageSize: 10
                }
            },
            formSearch: {
                'id': 1,
                'name': 'name',
                'type': 1,
                'status': 1

            },
            searchFormRules: searchFormRules,
            constants,
            localDicts
        };
    },
    mounted () {
        this.loadData();
    },
    components: {
        operate,
        dictLabel,
        dictSelect,
        dictCheckbox
    }
};
export default tableDefine;
