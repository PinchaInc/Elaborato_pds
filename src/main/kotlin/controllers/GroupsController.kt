package controllers

interface GroupsController {
    fun start()
    fun setApplication(app: Application): GroupsController
    //fun assignWork(groupID: Int, work: Any) TODO
    //fun setProgress(groupID: Int, meetingID: Int, progress: Any) TODO
}
