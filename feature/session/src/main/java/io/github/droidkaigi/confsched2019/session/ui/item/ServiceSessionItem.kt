package io.github.droidkaigi.confsched2019.session.ui.item

import com.xwray.groupie.databinding.BindableItem
import io.github.droidkaigi.confsched2019.model.Session
import io.github.droidkaigi.confsched2019.session.R
import io.github.droidkaigi.confsched2019.session.databinding.ItemServiceSessionBinding

class ServiceSessionItem(
    override val session: Session.ServiceSession
) : BindableItem<ItemServiceSessionBinding>(
    session.id.hashCode().toLong()
), SessionItem {
    val serviceSession get() = session

    override fun bind(viewBinding: ItemServiceSessionBinding, position: Int) {
        with(viewBinding) {
            session = serviceSession

            @Suppress("StringFormatMatches") // FIXME
            timeAndRoom.text = root.context.getString(
                R.string.session_duration_room_format,
                serviceSession.timeInMinutes,
                serviceSession.room.name
            )
        }
    }

    override fun getLayout(): Int = R.layout.item_service_session

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ServiceSessionItem

        if (session != other.session) return false

        return true
    }

    override fun hashCode(): Int {
        return session.hashCode()
    }
}
