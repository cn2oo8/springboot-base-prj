<template>
  <div>
    <Button type="primary" @click="showModal = true">
      <Icon type="plus"></Icon>
      新增 项目
    </Button>

    <Modal v-model="showModal"
           title="新增项目"
           @on-ok="save"
           @on-cancel="cancel">

      <Form ref="formItems" :model="formItems" :rules="formRules" :label-width="120" inline>

        <Row>
          <Col span="24">
            <Form-item label="名称" prop="name" style="width: 90%">
              <Input v-model="formItems.name" :maxlength="50" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="备注" prop="remark" style="width: 90%">
              <Input v-model="formItems.remark" :maxlength="500" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="项目key" prop="projectKey" style="width: 90%">
              <Input v-model="formItems.projectKey" :maxlength="50" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="类型" prop="type" style="width: 90%">
              <Input v-model="formItems.type" :maxlength="10" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="扩展1" prop="ext1" style="width: 90%">
              <Input v-model="formItems.ext1" :maxlength="50" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="扩展2" prop="ext2" style="width: 90%">
              <Input v-model="formItems.ext2" :maxlength="50" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="扩展3" prop="ext3" style="width: 90%">
              <Input v-model="formItems.ext3" :maxlength="50" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="创建人" prop="creator" style="width: 90%">
              <Input v-model="formItems.creator" :maxlength="20" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="修改人" prop="operator" style="width: 90%">
              <Input v-model="formItems.operator" :maxlength="20" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="并发版本号" prop="concurrentVersion" style="width: 90%">
              <Input v-model="formItems.concurrentVersion" :maxlength="19" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="数据版本" prop="dataVersion" style="width: 90%">
              <Input v-model="formItems.dataVersion" :maxlength="19" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

        <Row>
          <Col span="24">
            <Form-item label="状态" prop="status" style="width: 90%">
              <Input v-model="formItems.status" :maxlength="3" :disabled="disableInput"></Input>
            </Form-item>
          </Col>
        </Row>

      </Form>
      <div slot="footer">
        <Button type="default" @click="cancel">取消</Button>
        <Button type="primary" @click="save" :loading="loading">
          <Icon type="android-done"></Icon>
          保存
        </Button>
      </div>
    </Modal>

  </div>
</template>

<script>
import constants from '@/constants/constants.js'
import requestUtils from '@/request/requestUtils.js'

var validateSet = {
  name: [{ type: 'string', required: false, message: '名称不能为空', trigger: 'blur' }],
  remark: [{ type: 'string', required: false, message: '备注不能为空', trigger: 'blur' }],
  projectKey: [{ type: 'string', required: false, message: '项目key不能为空', trigger: 'blur' }],
  type: [{ type: 'integer', required: false, message: '类型不能为空', trigger: 'blur' }],
  ext1: [{ type: 'string', required: false, message: '扩展1不能为空', trigger: 'blur' }],
  ext2: [{ type: 'string', required: false, message: '扩展2不能为空', trigger: 'blur' }],
  ext3: [{ type: 'string', required: false, message: '扩展3不能为空', trigger: 'blur' }],
  creator: [{ type: 'string', required: false, message: '创建人不能为空', trigger: 'blur' }],
  operator: [{ type: 'string', required: false, message: '修改人不能为空', trigger: 'blur' }],
  concurrentVersion: [{ type: 'integer', required: false, message: '并发版本号不能为空', trigger: 'blur' }],
  dataVersion: [{ type: 'integer', required: false, message: '数据版本不能为空', trigger: 'blur' }],
  status: [{ type: 'integer', required: false, message: '状态不能为空', trigger: 'blur' }]
}

var formItems = {
  name: null,
  remark: null,
  projectKey: null,
  type: null,
  ext1: null,
  ext2: null,
  ext3: null,
  creator: null,
  operator: null,
  concurrentVersion: null,
  dataVersion: null,
  status: null
}

export default {
  data () {
    return {
      formItems: formItems,
      formRules: validateSet,
      // formRules: constants.rules.acProject.add,
      showModal: false,
      loading: false,
      disableInput: false
    }
  },

  methods: {
    save: function () {
      this.$refs['formItems'].validate((valid) => {
        if (!valid) {
          return false
        }
        requestUtils.postSubmit(this, constants.urls.conf.acProject.add, this.formItems, function (data) {
          this.$Message.success({
            content: '新增成功',
            duration: 3
          })
          this.showModal = false
          this.$emit(constants.actions.common.refreshList)
        })
      })
    },
    'cancel': function () {
      this.$refs['formItems'].resetFields()
      this.showModal = false
    }
  }
}
</script>
