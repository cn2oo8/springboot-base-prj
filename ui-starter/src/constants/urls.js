export default {
    common: {
        bindResource: {
            getBindResource: 'common/bindResource/getBindResource',
            saveBindResource: 'common/bindResource/saveBindResource'
        }
    },
    sys: {
        system: {
            getProfileCache: 'sys/system/getProfileCache'
        }
    },
    test: {
        acProject: {
            list: 'test/acProject/list',
            add: 'test/acProject/add',
            update: 'test/acProject/update',
            delete: 'test/acProject/delete',
            getByPk: 'test/acProject/getByPk'
        }
    }
}
