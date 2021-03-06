<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="课程id" prop="courseid">
      <el-input v-model="dataForm.courseid" placeholder="课程id"></el-input>
    </el-form-item>
    <el-form-item label="用户信息" prop="nickname">
      <el-input v-model="dataForm.nickname" placeholder="用户信息"></el-input>
    </el-form-item>
    <el-form-item label="状态》 1审核通过； 0审核未通过 ； 2 待审核" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态》 1审核通过； 0审核未通过 ； 2 待审核"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createtime">
      <el-input v-model="dataForm.createtime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="满意度" prop="satisfaction">
      <el-input v-model="dataForm.satisfaction" placeholder="满意度"></el-input>
    </el-form-item>
    <el-form-item label="点名情况" prop="countfrequency">
      <el-input v-model="dataForm.countfrequency" placeholder="点名情况"></el-input>
    </el-form-item>
    <el-form-item label="点名方式" prop="countway">
      <el-input v-model="dataForm.countway" placeholder="点名方式"></el-input>
    </el-form-item>
    <el-form-item label="考试方式" prop="exam">
      <el-input v-model="dataForm.exam" placeholder="考试方式"></el-input>
    </el-form-item>
    <el-form-item label="成绩范围" prop="grade">
      <el-input v-model="dataForm.grade" placeholder="成绩范围"></el-input>
    </el-form-item>
    <el-form-item label="评论" prop="remarks">
      <el-input v-model="dataForm.remarks" placeholder="评论"></el-input>
    </el-form-item>
    <el-form-item label="用户信息" prop="openid">
      <el-input v-model="dataForm.openid" placeholder="用户信息"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updatetime">
      <el-input v-model="dataForm.updatetime" placeholder="修改时间"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          courseid: '',
          nickname: '',
          status: '',
          createtime: '',
          satisfaction: '',
          countfrequency: '',
          countway: '',
          exam: '',
          grade: '',
          remarks: '',
          openid: '',
          updatetime: ''
        },
        dataRule: {
          courseid: [
            { required: true, message: '课程id不能为空', trigger: 'blur' }
          ],
          nickname: [
            { required: true, message: '用户信息不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态》 1审核通过； 0审核未通过 ； 2 待审核不能为空', trigger: 'blur' }
          ],
          createtime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          satisfaction: [
            { required: true, message: '满意度不能为空', trigger: 'blur' }
          ],
          countfrequency: [
            { required: true, message: '点名情况不能为空', trigger: 'blur' }
          ],
          countway: [
            { required: true, message: '点名方式不能为空', trigger: 'blur' }
          ],
          exam: [
            { required: true, message: '考试方式不能为空', trigger: 'blur' }
          ],
          grade: [
            { required: true, message: '成绩范围不能为空', trigger: 'blur' }
          ],
          remarks: [
            { required: true, message: '评论不能为空', trigger: 'blur' }
          ],
          openid: [
            { required: true, message: '用户信息不能为空', trigger: 'blur' }
          ],
          updatetime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/generator/coursecomment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.courseid = data.courseComment.courseid
                this.dataForm.nickname = data.courseComment.nickname
                this.dataForm.status = data.courseComment.status
                this.dataForm.createtime = data.courseComment.createtime
                this.dataForm.satisfaction = data.courseComment.satisfaction
                this.dataForm.countfrequency = data.courseComment.countfrequency
                this.dataForm.countway = data.courseComment.countway
                this.dataForm.exam = data.courseComment.exam
                this.dataForm.grade = data.courseComment.grade
                this.dataForm.remarks = data.courseComment.remarks
                this.dataForm.openid = data.courseComment.openid
                this.dataForm.updatetime = data.courseComment.updatetime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/coursecomment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'courseid': this.dataForm.courseid,
                'nickname': this.dataForm.nickname,
                'status': this.dataForm.status,
                'createtime': this.dataForm.createtime,
                'satisfaction': this.dataForm.satisfaction,
                'countfrequency': this.dataForm.countfrequency,
                'countway': this.dataForm.countway,
                'exam': this.dataForm.exam,
                'grade': this.dataForm.grade,
                'remarks': this.dataForm.remarks,
                'openid': this.dataForm.openid,
                'updatetime': this.dataForm.updatetime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
