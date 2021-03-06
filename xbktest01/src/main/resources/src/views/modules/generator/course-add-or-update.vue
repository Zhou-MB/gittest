<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="课程名" prop="course">
      <el-input v-model="dataForm.course" placeholder="课程名"></el-input>
    </el-form-item>
    <el-form-item label="是否核心 true false" prop="iscore">
      <el-input v-model="dataForm.iscore" placeholder="是否核心 true false"></el-input>
    </el-form-item>
    <el-form-item label="课程类型id 1:人文科学  2:科学技术 3:社会科学" prop="coursetypeid">
      <el-input v-model="dataForm.coursetypeid" placeholder="课程类型id 1:人文科学  2:科学技术 3:社会科学"></el-input>
    </el-form-item>
    <el-form-item label="课程类型名" prop="coursetype2">
      <el-input v-model="dataForm.coursetype2" placeholder="课程类型名"></el-input>
    </el-form-item>
    <el-form-item label="带核心的课程类型名" prop="coursetype">
      <el-input v-model="dataForm.coursetype" placeholder="带核心的课程类型名"></el-input>
    </el-form-item>
    <el-form-item label="教师" prop="teacher">
      <el-input v-model="dataForm.teacher" placeholder="教师"></el-input>
    </el-form-item>
    <el-form-item label="状态》 1审核通过； 0审核未通过 ； 2 待审核" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态》 1审核通过； 0审核未通过 ； 2 待审核"></el-input>
    </el-form-item>
    <el-form-item label="用户信息" prop="openid">
      <el-input v-model="dataForm.openid" placeholder="用户信息"></el-input>
    </el-form-item>
    <el-form-item label="用户信息" prop="nickname">
      <el-input v-model="dataForm.nickname" placeholder="用户信息"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createtime">
      <el-input v-model="dataForm.createtime" placeholder="创建时间"></el-input>
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
          courseid: 0,
          course: '',
          iscore: '',
          coursetypeid: '',
          coursetype2: '',
          coursetype: '',
          teacher: '',
          status: '',
          openid: '',
          nickname: '',
          createtime: '',
          updatetime: ''
        },
        dataRule: {
          course: [
            { required: true, message: '课程名不能为空', trigger: 'blur' }
          ],
          iscore: [
            { required: true, message: '是否核心 true false不能为空', trigger: 'blur' }
          ],
          coursetypeid: [
            { required: true, message: '课程类型id 1:人文科学  2:科学技术 3:社会科学不能为空', trigger: 'blur' }
          ],
          coursetype2: [
            { required: true, message: '课程类型名不能为空', trigger: 'blur' }
          ],
          coursetype: [
            { required: true, message: '带核心的课程类型名不能为空', trigger: 'blur' }
          ],
          teacher: [
            { required: true, message: '教师不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态》 1审核通过； 0审核未通过 ； 2 待审核不能为空', trigger: 'blur' }
          ],
          openid: [
            { required: true, message: '用户信息不能为空', trigger: 'blur' }
          ],
          nickname: [
            { required: true, message: '用户信息不能为空', trigger: 'blur' }
          ],
          createtime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updatetime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.courseid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.courseid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/course/info/${this.dataForm.courseid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.course = data.course.course
                this.dataForm.iscore = data.course.iscore
                this.dataForm.coursetypeid = data.course.coursetypeid
                this.dataForm.coursetype2 = data.course.coursetype2
                this.dataForm.coursetype = data.course.coursetype
                this.dataForm.teacher = data.course.teacher
                this.dataForm.status = data.course.status
                this.dataForm.openid = data.course.openid
                this.dataForm.nickname = data.course.nickname
                this.dataForm.createtime = data.course.createtime
                this.dataForm.updatetime = data.course.updatetime
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
              url: this.$http.adornUrl(`/generator/course/${!this.dataForm.courseid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'courseid': this.dataForm.courseid || undefined,
                'course': this.dataForm.course,
                'iscore': this.dataForm.iscore,
                'coursetypeid': this.dataForm.coursetypeid,
                'coursetype2': this.dataForm.coursetype2,
                'coursetype': this.dataForm.coursetype,
                'teacher': this.dataForm.teacher,
                'status': this.dataForm.status,
                'openid': this.dataForm.openid,
                'nickname': this.dataForm.nickname,
                'createtime': this.dataForm.createtime,
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
