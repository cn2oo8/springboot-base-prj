/**
 * 抽取出来方便
 */
import * as renderUtil from '@/libs/renderUtil.js'
import constants from '@/constants/constants'
import operate from './operate.vue'
import dictLabel from '@/view/components/dict/DictLabel'
import dictSelect from '@/view/components/dict/DictSelect'
import dictCheckbox from '@/view/components/dict/DictCheckBox'

const searchFormRules = {
  id: [{ type: 'string', required: false, message: 'id不能为空', trigger: 'blur' }],
  name: [{ type: 'string', required: false, message: '名称不能为空', trigger: 'blur' }],
  type: [{ type: 'integer', required: false, message: '类型不能为空', trigger: 'blur' }],
  status: [{ type: 'integer', required: false, message: '状态不能为空', trigger: 'blur' }]
}

let tableDefine = {
  data () {
    return {
      loading: false,
      columns: [

        {
          title: 'id',
          key: 'id',
          width: 100
        },

        {
          title: '名称',
          key: 'name',
          width: 100
        },

        {
          title: '项目key',
          key: 'projectKey',
          width: 100
        },

        {
          title: '类型',
          width: 100,
          render: (h, params) => {
            return h(dictLabel, {
              props: {
                value: params.row['type'],
                kind: constants.dicts.dictKinds.acProject_type_DICT,
                showStyle: true
              }
            })
          }
        },

        {
          title: '扩展1',
          key: 'ext1',
          width: 100
        },

        {
          title: '扩展2',
          key: 'ext2',
          width: 100
        },

        {
          title: '扩展3',
          key: 'ext3',
          width: 100
        },

        {
          title: '创建人',
          key: 'creator',
          width: 100
        },

        {
          title: '修改人',
          key: 'operator',
          width: 100
        },

        {
          title: '并发版本号',
          key: 'concurrentVersion',
          width: 100
        },

        {
          title: '数据版本',
          key: 'dataVersion',
          width: 100
        },

        {
          title: '状态',
          width: 100,
          render: (h, params) => {
            return h(dictLabel, {
              props: {
                value: params.row['status'],
                kind: constants.dicts.dictKinds.acProject_status_DICT,
                showStyle: true
              }
            })
          }
        },

        {
          title: '修改时间',
          key: 'modified',
          width: 100,
          render: (h, params) => {
            return h('div', renderUtil.formatDateTime(params.row.modified))
          }
        },

        {
          title: '操作',
          key: 'action',
          width: 150,
          fixed: 'right',
          align: 'center',
          render: (h, params) => {
            return h(operate, {
              props: {
                item: params.row
              },
              on: {
                'refreshList': () => {
                  this.loadData()
                },
                'updateItem': (item) => {
                  this.editItem(item)
                }
              }
            })
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
        'id': '',
        'name': '',
        'type': null,
        'status': 1

      },
      searchFormRules: searchFormRules,
      constants
    }
  },
  mounted () {
    this.loadData()
  },
  components: {
    operate,
    dictLabel,
    dictSelect,
    dictCheckbox
  }
}
export default tableDefine
