/**
 * 哨兵捡漏模式 可长时间运行 此模式不能用于高峰期下单
 */
public class Sentinel4SamCapacity {


    public static void main(String[] args) {
        //x点xx分xx秒时间触发
//        while (!Util.timeTrigger(8, 00, 00)) {
//        }



        //最小订单成交金额 举例如果设置成50 那么订单要超过50才会下单
        double minOrderPrice = 0;

        //执行任务请求间隔时间最小值
        int sleepMillisMin = 30000;
        //执行任务请求间隔时间最大值
        int sleepMillisMax = 60000;

        //单轮轮询时请求异常（叮咚服务器高峰期限流策略）尝试次数
        int loopTryCount = 10;

        //60次以后长时间等待10分钟左右
        int longWaitCount = 0;

        boolean first = true;
        while (!Api.context.containsKey("end")) {
            try {
//                if (first) {
//                    first = false;
//                } else {
//                    if (longWaitCount++ > 60) {
//                        longWaitCount = 0;
//                        System.out.println("执行60次循环后，休息10分钟左右再继续");
//                        Util.sleep(RandomUtil.randomInt(500000, 700000));
//                    } else {
//                        Util.sleep(RandomUtil.randomInt(sleepMillisMin, sleepMillisMax));
//                    }
//                }

                Api.getSamCapacity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
