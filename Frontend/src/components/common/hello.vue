<template>
  <section class="index">
    <div class="hello">
      <i class="iconfont icon-xihuan"></i><span>Nice to meet you,{{user.userName}}老师。</span>
    </div>
    <div class="msg">
      <p class="title">Academic Affairs Announcement:</p>
      <ul>
        <li @click="openMsg()"><i class="iconfont icon-flag"></i>Holiday notice for Qingming Festival</li>
        <li @click="openMsg()"><i class="iconfont icon-flag"></i>Next week's regular work report meeting</li>
        <li @click="openMsg()"><i class="iconfont icon-flag"></i>About the specific process of graduate defense</li>
      </ul>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {
      user: { //用户信息
        userName: null,
        userId: null
      } 
    }
  },
  created() {
    this.getUserInfo()
  },
  methods: {
    getUserInfo() { //获取用户信息
      let userName = this.$cookies.get("cname")
      let userId = this.$cookies.get("cid")
      this.user.userName = userName
      this.user.userId = userId
    },
    openMsg() {
      this.$alert('In accordance with the spirit of the Notice of the General Office of the State Council on the Arrangement of Some Holidays in 2019, the Yuecheng District Administrative Service Center will carry out the Qingming Festival holiday from April 5 (Friday) to April 7 (Sunday), a total of 3 days, and no business will be accepted during the holiday. On Monday, April 8, we will start accepting business as normal. We hope that the public and friends will inform each other and apologize for any inconvenience caused.','Holiday notice for Qingming Festival',{
        confirmButtonText: 'Confirm'
      })
    }
  }
}
</script>


<style lang="less" scoped>
.index {
  margin-left: 70px;
  .hello {
    font-size: 20px;
    color: #726f70;
    .icon-xihuan {
      font-size: 30px;
      color: #dd6572;
    }
  }
  .msg {
    .title {
      font-size: 16px;
      color: #000;
      margin-top: 20px;
      margin-left: 10px;
    }
    ul {
      display: flex;
      flex-direction: column;
      width: 200px;
      overflow: hidden;
    }
    li {
      margin-top: 10px;
      font-size: 14px;
      color: lightcoral;
      cursor: pointer;
      display: inline-block;
    }
  }
}
</style>

