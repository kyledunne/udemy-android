package iheart.kdunne.top10downloader

import android.util.Log
import java.net.URL
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class DownloadDataTask(val mainActivity: MainActivity, val url: String): Future<String> {
    val TAG = "DownloadDataTask"
    var done = false

    /**
     * Returns `true` if this task completed.
     *
     * Completion may be due to normal termination, an exception, or
     * cancellation -- in all of these cases, this method will return
     * `true`.
     *
     * @return `true` if this task completed
     */
    override fun isDone() = done

    /**
     * Waits if necessary for the computation to complete, and then
     * retrieves its result.
     *
     * @return the computed result
     * @throws CancellationException if the computation was cancelled
     * @throws ExecutionException if the computation threw an
     * exception
     * @throws InterruptedException if the current thread was interrupted
     * while waiting
     */
    override fun get(): String {
        Log.d(TAG, "DownloadDataTask.get() called")

        val rssFeed = URL(url).readText()
        if (rssFeed.isEmpty()) {
            Log.e(TAG, "DownloadDataTask.get(): Error downloading")
        }

        mainActivity.feedCachedUrl = url

        mainActivity.currentApplications = ParseApplications()
        mainActivity.currentApplications!!.parse(rssFeed)

        Log.d(TAG, "Finished downloading URL in DownloadDataTask.get()")
        done = true
        return ""
    }

    /**
     * Waits if necessary for at most the given time for the computation
     * to complete, and then retrieves its result, if available.
     *
     * @param timeout the maximum time to wait
     * @param unit the time unit of the timeout argument
     * @return the computed result
     * @throws CancellationException if the computation was cancelled
     * @throws ExecutionException if the computation threw an
     * exception
     * @throws InterruptedException if the current thread was interrupted
     * while waiting
     * @throws TimeoutException if the wait timed out
     */
    override fun get(timeout: Long, unit: TimeUnit): String {
        Log.d(TAG, "DownloadDataTask.get(timeout, unit) called. Oops!")
        return ""
    }

    /**
     * Attempts to cancel execution of this task.  This attempt will
     * fail if the task has already completed, has already been cancelled,
     * or could not be cancelled for some other reason. If successful,
     * and this task has not started when `cancel` is called,
     * this task should never run.  If the task has already started,
     * then the `mayInterruptIfRunning` parameter determines
     * whether the thread executing this task should be interrupted in
     * an attempt to stop the task.
     *
     *
     * After this method returns, subsequent calls to [.isDone] will
     * always return `true`.  Subsequent calls to [.isCancelled]
     * will always return `true` if this method returned `true`.
     *
     * @param mayInterruptIfRunning `true` if the thread executing this
     * task should be interrupted; otherwise, in-progress tasks are allowed
     * to complete
     * @return `false` if the task could not be cancelled,
     * typically because it has already completed normally;
     * `true` otherwise
     */
    override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Returns `true` if this task was cancelled before it completed
     * normally.
     *
     * @return `true` if this task was cancelled before it completed
     */
    override fun isCancelled(): Boolean {
        TODO("Not yet implemented")
    }
}