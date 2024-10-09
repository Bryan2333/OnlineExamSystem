<!-- 添加教师 -->
<template>
  <section class="add">
    <el-form ref="form" :model="form" label-width="100px">
      <el-form-item label="Name">
            <el-input v-model="form.teacherName"></el-input>
          </el-form-item>
          <el-form-item label="Institue">
            <el-input v-model="form.institute"></el-input>
          </el-form-item>
          <el-form-item label="Sex">
            <el-input v-model="form.sex"></el-input>
          </el-form-item>
          <el-form-item label="Phone num">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
          <el-form-item label="Email">
            <el-input v-model="form.email"></el-input>
          </el-form-item>
          <el-form-item label="Password">
            <el-input v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item label="ID">
            <el-input v-model="form.cardId"></el-input>
          </el-form-item>
          <el-form-item label="Type">
            <el-input v-model="form.type"></el-input>
          </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()">Create</el-button>
        <el-button type="text" @click="cancel()">Cancel</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>

<script>
export default {
  data() {
    return {
      form: { //表单数据初始化
        teacherName: null,
        grade: null,
        major: null,
        clazz: null,
        institute: null,
        phone: null,
        email: null,
        password: null,
        cardId: null,
        sex: null,
        role: 2
      }
    };
  },
  methods: {
    onSubmit() { //数据提交
      this.$axios({
        url: '/teacher',
        method: 'post',
        data: {
          ...this.form
        }
      }).then(res => {
        if(res.data.code === 200) {
          this.$message({
            message: 'Add successfully',
            type: 'success'
          })
          this.$router.push({path: '/teacherManage'})
        }
      })
    },
    cancel() { //取消按钮
      this.form = {}
    }
  }
};
</script>
<style lang="less" scoped>
.add {
  padding: 0 40px;
  width: 400px;
}
</style>

