package models.Urls

/**
 * Created with IntelliJ IDEA.
 * User: ldew
 * Date: 18/02/13
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
object Urls {

  //hardcode a list for now
  lazy val urls : Map[Long, Trail] = Map(
    1L ->
    new Trail("http://www.guardian.co.uk/global/2013/feb/18/bbc-strike-live-coverage",
          "BBC strike - live coverage",
          "Radio 4's Today and BBC1's Breakfast off air as staff stage a 24-hour stoppage over proposed compulsory redundancies. By Dugald Baird and Josh Halliday",
          "http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2013/2/18/1361183809068/-140x84.jpeg"),
    2L  ->
    new Trail("http://www.guardian.co.uk/world/2013/feb/18/hugo-chavez-returns-venezuela",
          "Hugo Chávez returns home to Venezuela",
          "Venezuelan president at military hospital in Caracas after returning from more than two months of treatment in Cuba",
          "http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2013/2/18/1361189304470/Hugo-Chavez-with-his-daug-003.jpg"),
    3L ->
    new Trail("http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2013/2/18/1361189304470/Hugo-Chavez-with-his-daug-003.jpg",
          "From grassroots to the gods: why British theatre is changinG",
          "New faces in leading institutions are a welcome sight – but we might need to redefine what we mean by mainstream",
          "http://static.guim.co.uk/sys-images/Arts/Arts_/Pictures/2013/2/18/1361187788797/The-Snow-Queen-performed--005.jpg"),
    4L ->
    new Trail("http://www.guardian.co.uk/stage/theatreblog/2013/feb/18/british-theatre-changing",
          "Picture desk live: the best news pictures of the day",
          "Our photo coverage of the day's events in the UK and around the world",
          "http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2013/2/18/1361180887671/Indian-bodybuilders--002.jpg"),
    5L  ->
    new Trail("http://www.guardian.co.uk/football/video/2013/feb/18/ronaldinho-water-bottle-assist-video",
          "Ronaldinho's sneaky water bottle assist – video",
          "At first glance in this footage, Ronaldinho appears to be bizarrely unmarked as he sets up a goal for Atlético Mineiro in their 2-1 win over São Paulo in the Copa Libertadores",
          "http://static.guim.co.uk/sys-images/Guardian/Pix/audio/video/2013/2/18/1361189018017/Is-Ronaldinhos-water-bott-010.jpg"),
    6L ->
    new Trail("books/booksblog/2013/feb/18/unread-unreadable-books",
          "In theory: the unread and the unreadable",
          "We measure our lives with unread books – and 'difficult' works can induce the most guilt. How should we view this challenge?",
          "http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2012/12/19/1355939525198/James-Joyce-pictured-in-1-005.jpg"),
    7L  ->
    new Trail("http://www.guardian.co.uk/books/2013/feb/18/rare-poem-worst-poet-auction",
          "Rare poem by 'world's worst poet' expected to fetch £3,000 at auction",
          "19th-century poet William Topaz McGonagall, whose works were so detested he was pelted with rotten fish, has last laugh",
          "http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2013/2/18/1361190756707/Scottish-poet-William-McG-003.jpg"),
    8L ->
    new Trail("http://www.guardian.co.uk/technology/2013/feb/18/sonos-soundbar-home-theatre-system",
          "Sonos Soundbar aims to ease pain of setting up home theatre sound systems",
          "Co-founder Tom Cullen talks smart speakers and why it's taken so long for Apple to launch a music streaming service. By Charles Arthur",
          "http://static.guim.co.uk/sys-images/Media/Pix/gallery/2013/2/18/1361190974196/Sonos-Soundbar-003.jpg"),
    9L  ->
    new Trail("http://www.guardian.co.uk/uk/scotland-blog/2013/feb/18/scotland-firstworldwar",
          "Mystery over world war one suitcase discovered in university cupboard",
          "Billy Briggs on the curious case of a battered suitcase belonging to a nurse who tended wounded German soldiers in Kent",
          "http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2013/2/18/1361190774822/A-battered-suitcase-fille-005.jpg"),
    10L  ->
    new Trail("http://www.guardian.co.uk/info/developer-blog/2013/feb/18/guardian-hack-day-february-2013-day-1",
          "Guardian Hack Day February 2013 — Live Blog Day 1",
          "Follow our digital development team as they spend a Hack Day working on prototypes of potential new developments for the Guardian",
          "http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2013/2/18/1361177479146/-140x84.jpeg")
  )
}

class Trail( webUrl: String, webTitle: String, trailText : String, trailPic: String) {
  def getWebTitle() : String = webTitle
  def getTrailText() : String = trailText
  def getTrailPic() : String = trailPic
  def getWebUrl() : String = webUrl

}
object Trail {
  def apply(webUrl: String, webTitle: String, trailText : String, trailPic: String)   {
    new Trail(webUrl, webTitle, trailText, trailPic)
  }
}

case class ClickCount(id: Long, no_of_clicks: Long) {
  def getId() : String = id.toString
  def getNoOfClicks : String = no_of_clicks.toString
}


