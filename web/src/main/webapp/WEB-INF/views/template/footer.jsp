<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUrl" value="${pageContext.request.contextPath}" />
        <footer class="page-footer green">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text"><mytaglib:i18n key="footer.copyright" /></h5>
              </div>
              <div class="nav-wrapper container">
              			<ul id="nav-mobile" class="right">
              				<li><a class="white-text" href="${baseUrl}?language=ru">RU</a></li>
              				<li><a class="white-text" href="${baseUrl}?language=en">EN</a></li>
              			</ul>
              		</div>
            </div>
          </div>
        </footer>

